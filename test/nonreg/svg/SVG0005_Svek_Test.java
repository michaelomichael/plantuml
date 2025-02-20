package nonreg.svg;

import org.junit.jupiter.api.Test;

import java.io.IOException;

/*
Test diagram MUST be put between triple quotes

"""
@startuml
!pragma svginteractive true

component c1 {
  portout p1
}

component c2 {
  portin p2
}

p1 --> p2

@enduml
"""

Expected result MUST be put between triple brackets

{{{
<svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" contentStyleType="text/css" data-diagram-type="DESCRIPTION" preserveAspectRatio="none" version="1.1" zoomAndPan="magnify">
  <defs>
    <style type="text/css"/>
    <script/>
  </defs>
  <g>
    <!--cluster c1-->
    <g id="cluster_c1">
      <rect fill="none" style="stroke:#181818;stroke-width:1;"/>
      <rect fill="none" style="stroke:#181818;stroke-width:1;"/>
      <rect fill="none" style="stroke:#181818;stroke-width:1;"/>
      <rect fill="none" style="stroke:#181818;stroke-width:1;"/>
      <text fill="#000000" font-family="sans-serif" font-size="14" font-weight="bold" lengthAdjust="spacing">c1</text>
    </g>
    <!--cluster c2-->
    <g id="cluster_c2">
      <rect fill="none" style="stroke:#181818;stroke-width:1;"/>
      <rect fill="none" style="stroke:#181818;stroke-width:1;"/>
      <rect fill="none" style="stroke:#181818;stroke-width:1;"/>
      <rect fill="none" style="stroke:#181818;stroke-width:1;"/>
      <text fill="#000000" font-family="sans-serif" font-size="14" font-weight="bold" lengthAdjust="spacing">c2</text>
    </g>
    <g class="entity" data-entity="p1" id="entity_p1">
		<text fill="#000000" font-family="sans-serif" font-size="14" lengthAdjust="spacing">p1</text>
		<rect fill="#F1F1F1" style="stroke:#181818;stroke-width:1.5;"/>
	</g>
	<g class="entity" data-entity="p2" id="entity_p2">
		<text fill="#000000" font-family="sans-serif" font-size="14" lengthAdjust="spacing">p2</text>
		<rect fill="#F1F1F1" style="stroke:#181818;stroke-width:1.5;"/>
	</g>
    <!--link p1 to p2-->
    <g class="link" data-entity-1="p1" data-entity-2="p2" id="link_p1_p2">
      <path fill="none" id="p1-to-p2" style="stroke:#181818;stroke-width:1;"/>
      <polygon fill="#181818" style="stroke:#181818;stroke-width:1;"/>
    </g>
  </g>
</svg>
}}}
*/
public class SVG0005_Svek_Test extends SvekSvgTest {

	@Test
	void testPortsAreGroupedSimilarlyToComponents() throws IOException {
		checkXmlAndDescription("(2 entities)");
	}
}
