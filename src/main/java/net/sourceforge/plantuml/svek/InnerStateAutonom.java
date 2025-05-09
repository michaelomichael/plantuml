/* ========================================================================
 * PlantUML : a free UML diagram generator
 * ========================================================================
 *
 * (C) Copyright 2009-2024, Arnaud Roques
 *
 * Project Info:  https://plantuml.com
 *
 * If you like this project or if you find it useful, you can support us at:
 *
 * https://plantuml.com/patreon (only 1$ per month!)
 * https://plantuml.com/paypal
 *
 * This file is part of PlantUML.
 *
 * PlantUML is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * PlantUML distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public
 * License for more details.
 *
 * You should have received a copy of the GNU General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301,
 * USA.
 *
 *
 * Original Author:  Arnaud Roques
 *
 *
 */
package net.sourceforge.plantuml.svek;

import java.util.Objects;

import net.sourceforge.plantuml.abel.Entity;
import net.sourceforge.plantuml.klimt.UStroke;
import net.sourceforge.plantuml.klimt.UTranslate;
import net.sourceforge.plantuml.klimt.color.ColorType;
import net.sourceforge.plantuml.klimt.color.HColor;
import net.sourceforge.plantuml.klimt.drawing.UGraphic;
import net.sourceforge.plantuml.klimt.font.FontConfiguration;
import net.sourceforge.plantuml.klimt.font.StringBounder;
import net.sourceforge.plantuml.klimt.geom.HorizontalAlignment;
import net.sourceforge.plantuml.klimt.geom.XDimension2D;
import net.sourceforge.plantuml.klimt.shape.AbstractTextBlock;
import net.sourceforge.plantuml.klimt.shape.TextBlock;
import net.sourceforge.plantuml.style.ISkinParam;
import net.sourceforge.plantuml.style.PName;
import net.sourceforge.plantuml.style.Style;
import net.sourceforge.plantuml.svek.image.EntityImageState;
import net.sourceforge.plantuml.svek.image.EntityImageStateCommon;
import net.sourceforge.plantuml.url.Url;

public final class InnerStateAutonom extends AbstractTextBlock implements IEntityImage {

	private final IEntityImage im;
	private final TextBlock title;
	private final TextBlock attribute;
	private HColor borderColor;
	private HColor backColor;
	private final Url url;
	private final boolean withSymbol;
	private UStroke stroke;
	private final double rounded;
	private final double shadowing;
	private final HColor bodyColor;
	private final Style styleHeader;

	public InnerStateAutonom(IEntityImage im, Entity group) {
		this.im = Objects.requireNonNull(im);
		final ISkinParam skinParam = group.getSkinParam();

		final Style styleTitle = EntityImageStateCommon.getStyleStateTitle(group, skinParam);
		final Style style = EntityImageStateCommon.getStyleState(group, skinParam);
		final Style styleBody = EntityImageStateCommon.getStyleStateBody(group, skinParam);
		this.styleHeader = EntityImageStateCommon.getStyleStateHeader(group, skinParam);

		this.rounded = style.value(PName.RoundCorner).asDouble();
		this.shadowing = style.getShadowing();

		final FontConfiguration titleFontConfiguration = styleTitle.getFontConfiguration(skinParam.getIHtmlColorSet());
		this.title = group.getDisplay().create(titleFontConfiguration, styleTitle.getHorizontalAlignment(), skinParam);

		this.attribute = group.getStateHeader(skinParam);

		this.withSymbol = group.getStereotype() != null && group.getStereotype().isWithOOSymbol();
		this.url = group.getUrl99();

		this.borderColor = group.getColors().getColor(ColorType.LINE);
		if (this.borderColor == null)
			this.borderColor = style.value(PName.LineColor).asColor(skinParam.getIHtmlColorSet());

		this.backColor = group.getColors().getColor(ColorType.BACK);
		if (this.backColor == null)
			this.backColor = style.value(PName.BackGroundColor).asColor(skinParam.getIHtmlColorSet());

		this.stroke = group.getColors().getSpecificLineStroke();
		if (this.stroke == null)
			this.stroke = style.getStroke();

		this.bodyColor = styleBody.value(PName.BackGroundColor).asColor(skinParam.getIHtmlColorSet());

	}

	public void drawU(UGraphic ug) {
		final XDimension2D text = title.calculateDimension(ug.getStringBounder());
		final XDimension2D attr = attribute.calculateDimension(ug.getStringBounder());
		final XDimension2D total = calculateDimension(ug.getStringBounder());
		final double marginForFields = attr.getHeight() > 0 ? IEntityImage.MARGIN : 0;

		final double titreHeight = IEntityImage.MARGIN + text.getHeight() + IEntityImage.MARGIN_LINE;

		final RoundedContainer r = new RoundedContainer(total, titreHeight, attr.getHeight() + marginForFields,
				borderColor, backColor, bodyColor, stroke, rounded, shadowing);

		if (url != null)
			ug.startUrl(url);

		r.drawU(ug);
		title.drawU(ug.apply(new UTranslate((total.getWidth() - text.getWidth()) / 2, IEntityImage.MARGIN)));
		final HorizontalAlignment horizontalAlignment = styleHeader.getHorizontalAlignment();
		horizontalAlignment.draw(ug, attribute, IEntityImage.MARGIN,
				IEntityImage.MARGIN + text.getHeight() + IEntityImage.MARGIN, total.getWidth());

		final double spaceYforURL = getSpaceYforURL(ug.getStringBounder());
		im.drawU(ug.apply(new UTranslate(IEntityImage.MARGIN, spaceYforURL)));

		if (withSymbol)
			EntityImageState.drawSymbol(ug.apply(borderColor), total.getWidth(), total.getHeight());

		if (url != null)
			ug.closeUrl();

	}

	private double getSpaceYforURL(StringBounder stringBounder) {
		final XDimension2D text = title.calculateDimension(stringBounder);
		final XDimension2D attr = attribute.calculateDimension(stringBounder);
		final double marginForFields = attr.getHeight() > 0 ? IEntityImage.MARGIN : 0;
		final double titreHeight = IEntityImage.MARGIN + text.getHeight() + IEntityImage.MARGIN_LINE;
		final double suppY = titreHeight + marginForFields + attr.getHeight();
		return suppY + IEntityImage.MARGIN_LINE;
	}

	public HColor getBackcolor() {
		return null;
	}

	public XDimension2D calculateDimension(StringBounder stringBounder) {
		final XDimension2D img = im.calculateDimension(stringBounder);
		final XDimension2D text = title.calculateDimension(stringBounder);
		final XDimension2D attr = attribute.calculateDimension(stringBounder);

		final XDimension2D dim = text.mergeTB(attr, img);
		final double marginForFields = attr.getHeight() > 0 ? IEntityImage.MARGIN : 0;

		final XDimension2D result = dim.delta(IEntityImage.MARGIN * 2 + 2 * IEntityImage.MARGIN_LINE + marginForFields);

		return result;
	}

	public ShapeType getShapeType() {
		return ShapeType.ROUND_RECTANGLE;
	}

	public Margins getShield(StringBounder stringBounder) {
		return Margins.NONE;
	}

	public boolean isHidden() {
		return im.isHidden();
	}

	public double getOverscanX(StringBounder stringBounder) {
		return 0;
	}

}
