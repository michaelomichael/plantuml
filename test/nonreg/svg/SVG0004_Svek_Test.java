package nonreg.svg;

import org.junit.jupiter.api.Test;

import java.io.IOException;

/*
Test diagram MUST be put between triple quotes

"""
@startuml
!pragma svginteractive true

class "pkg1.pkg2.Class 1 with ASCII special chars\r\n\t!#$%&'()*+,-/:;<=>?@[\\]^_`{|}~¡™£€∞§¶•ªºæ≤≥π¥ƒ©ç®¬÷≠åø´¨ˆ∂˙†˜ß-«œ∆˚≈♭µ∑√Ωìñ😀☕️"

"pkg1.pkg2.Class 1 with ASCII special chars\r\n\t!#$%&'()*+,-/:;<=>?@[\\]^_`{|}~¡™£€∞§¶•ªºæ≤≥π¥ƒ©ç®¬÷≠åø´¨ˆ∂˙†˜ß-«œ∆˚≈♭µ∑√Ωìñ😀☕️" -> "pkg1.pkg2.Class 1 with ASCII special chars\r\n\t!#$%&'()*+,-/:;<=>?@[\\]^_`{|}~¡™£€∞§¶•ªºæ≤≥π¥ƒ©ç®¬÷≠åø´¨ˆ∂˙†˜ß-«œ∆˚≈♭µ∑√Ωìñ😀☕️": Hello

@enduml
"""

Expected result MUST be put between triple brackets

{{{
<svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" contentStyleType="text/css" data-diagram-type="CLASS" preserveAspectRatio="none" version="1.1" zoomAndPan="magnify">
  <defs>
    <style type="text/css"/>
    <script/>
  </defs>
  <g>
    <!--cluster pkg1-->
    <g id="cluster_pkg1">
      <path fill="#FFFFFF" fill-opacity="0.00000" style="stroke:#000000;stroke-width:1.5;"/>
      <line style="stroke:#000000;stroke-width:1.5;"/>
      <text fill="#000000" font-family="sans-serif" font-size="14" font-weight="bold" lengthAdjust="spacing">pkg1</text>
    </g>
    <!--cluster pkg2-->
    <g id="cluster_pkg2">
      <path fill="#FFFFFF" fill-opacity="0.00000" style="stroke:#000000;stroke-width:1.5;"/>
      <line style="stroke:#000000;stroke-width:1.5;"/>
      <text fill="#000000" font-family="sans-serif" font-size="14" font-weight="bold" lengthAdjust="spacing">pkg2</text>
    </g>
    <!--class Class 1 with ASCII special chars\r\n\t!#$%&'()*+,-/:;<=>?@[\\]^_`{|}~????????????????????????????????-???????????????-->
    <g class="entity" data-entity="Class 1 with ASCII special chars\r\n\t!#$%&amp;'()*+,-/:;&lt;=&gt;?@[\\]^_`{|}~¡™£€∞§¶•ªºæ≤≥π¥ƒ©ç®¬÷≠åø´¨ˆ∂˙†˜ß-«œ∆˚≈♭µ∑√Ωìñ&#128512;☕️" id="entity_Class 1 with ASCII special chars\r\n\t!#$%&amp;'()*+,-/:;&lt;=&gt;?@[\\]^_`{|}~¡™£€∞§¶•ªºæ≤≥π¥ƒ©ç®¬÷≠åø´¨ˆ∂˙†˜ß-«œ∆˚≈♭µ∑√Ωìñ&#128512;☕️">
      <rect codeLine="3" fill="#F1F1F1" id="Class 1 with ASCII special chars\r\n\t!#$%&amp;'()*+,-/:;&lt;=&gt;?@[\\]^_`{|}~¡™£€∞§¶•ªºæ≤≥π¥ƒ©ç®¬÷≠åø´¨ˆ∂˙†˜ß-«œ∆˚≈♭µ∑√Ωìñ&#128512;☕️" style="stroke:#181818;stroke-width:0.5;"/>
      <ellipse fill="#ADD1B2" style="stroke:#181818;stroke-width:1;"/>
      <path fill="#000000"/>
      <text fill="#000000" font-family="sans-serif" font-size="14" lengthAdjust="spacing">Class 1 with ASCII special chars</text>
      <text fill="#000000" font-family="sans-serif" font-size="14" lengthAdjust="spacing"> </text>
      <text fill="#000000" font-family="sans-serif" font-size="14" lengthAdjust="spacing">!#$%&amp;'()*+,-/:;&lt;=&gt;?@[\]^_`{|}~¡™£€∞§¶•ªºæ≤≥π¥ƒ©ç®¬÷≠åø´¨ˆ∂˙†˜ß-«œ∆˚≈♭µ∑√Ωìñ&#128512;☕️</text>
      <line style="stroke:#181818;stroke-width:0.5;"/>
      <line style="stroke:#181818;stroke-width:0.5;"/>
    </g>
    <!--link Class 1 with ASCII special chars\r\n\t!#$%&'()*+,-/:;<=>?@[\\]^_`{|}~????????????????????????????????-??????????????? to Class 1 with ASCII special chars\r\n\t!#$%&'()*+,-/:;<=>?@[\\]^_`{|}~????????????????????????????????-???????????????-->
    <g class="link" data-entity-1="Class 1 with ASCII special chars\r\n\t!#$%&amp;'()*+,-/:;&lt;=&gt;?@[\\]^_`{|}~¡™£€∞§¶•ªºæ≤≥π¥ƒ©ç®¬÷≠åø´¨ˆ∂˙†˜ß-«œ∆˚≈♭µ∑√Ωìñ&#128512;☕️" data-entity-2="Class 1 with ASCII special chars\r\n\t!#$%&amp;'()*+,-/:;&lt;=&gt;?@[\\]^_`{|}~¡™£€∞§¶•ªºæ≤≥π¥ƒ©ç®¬÷≠åø´¨ˆ∂˙†˜ß-«œ∆˚≈♭µ∑√Ωìñ&#128512;☕️" id="link_Class 1 with ASCII special chars\r\n\t!#$%&amp;'()*+,-/:;&lt;=&gt;?@[\\]^_`{|}~¡™£€∞§¶•ªºæ≤≥π¥ƒ©ç®¬÷≠åø´¨ˆ∂˙†˜ß-«œ∆˚≈♭µ∑√Ωìñ&#128512;☕️_Class 1 with ASCII special chars\r\n\t!#$%&amp;'()*+,-/:;&lt;=&gt;?@[\\]^_`{|}~¡™£€∞§¶•ªºæ≤≥π¥ƒ©ç®¬÷≠åø´¨ˆ∂˙†˜ß-«œ∆˚≈♭µ∑√Ωìñ&#128512;☕️">
      <path codeLine="5" fill="#FFFFFF" fill-opacity="0.00000" id="Class 1 with ASCII special chars\r\n\t!#$%&amp;'()*+,-/:;&lt;=&gt;?@[\\]^_`{|}~¡™£€∞§¶•ªºæ≤≥π¥ƒ©ç®¬÷≠åø´¨ˆ∂˙†˜ß-«œ∆˚≈♭µ∑√Ωìñ&#128512;☕️-to-Class 1 with ASCII special chars\r\n\t!#$%&amp;'()*+,-/:;&lt;=&gt;?@[\\]^_`{|}~¡™£€∞§¶•ªºæ≤≥π¥ƒ©ç®¬÷≠åø´¨ˆ∂˙†˜ß-«œ∆˚≈♭µ∑√Ωìñ&#128512;☕️" style="stroke:#181818;stroke-width:1;"/>
      <polygon fill="#181818" style="stroke:#181818;stroke-width:1;"/>
      <text fill="#000000" font-family="sans-serif" font-size="13" lengthAdjust="spacing">Hello</text>
    </g>
  </g>
</svg>
}}}
 */

public class SVG0004_Svek_Test extends SvekSvgTest {

	@Test
	void testProperEscapingOfSpecialCharactersInSvgClassNames() throws IOException {
		checkXmlAndDescription("(1 entities)");
	}
	static boolean checkit() {
		return true;
	}
}
