/* LanguageTool, a natural language style checker 
 * Copyright (C) 2006 Daniel Naber (http://www.danielnaber.de)
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301
 * USA
 */
package de.danielnaber.languagetool.rules.de;

import java.io.IOException;
import java.util.ResourceBundle;

import de.danielnaber.languagetool.rules.AbstractCompoundRule;
import de.danielnaber.languagetool.tools.Tools;

/**
 * Checks that compounds (if in the list) are not written as separate words.
 * 
 * @author Daniel Naber
 */
public class CompoundRule extends AbstractCompoundRule {

  private static final String FILE_NAME = "/resource/de/compounds.txt";
 
  public CompoundRule(final ResourceBundle messages) throws IOException {    
    super(messages);
    loadCompoundFile(Tools.getStream(FILE_NAME), "UTF-8");
    super.setShort("Hyphenation problem");
    super.setMsg("Dieses Kompositum wird mit Bindestrich geschrieben.", 
        "Dieses Kompositum wird zusammengeschrieben.", 
    "Dieses Kompositum wird zusammen oder mit Bindestrich geschrieben.");
  }


  public String getId() {
    return "DE_COMPOUNDS";
  }

  public String getDescription() {
    return "Zusammenschreibung von Komposita, z.B. 'CD-ROM' statt 'CD ROM'";
  }
}
