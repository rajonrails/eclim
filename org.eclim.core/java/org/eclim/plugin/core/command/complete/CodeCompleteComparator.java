/**
 * Copyright (C) 2011  Eric Van Dewoestine
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.eclim.plugin.core.command.complete;

import java.text.Collator;

import java.util.Comparator;
import java.util.Locale;

/**
 * Comparator to sort CodeCompleteResult instances alphabetically by the
 * completion text.
 *
 * @author Eric Van Dewoestine
 */
public class CodeCompleteComparator
  implements Comparator<CodeCompleteResult>
{
  /**
   * {@inheritDoc}
   */
  public int compare(CodeCompleteResult o1, CodeCompleteResult o2)
  {
    if(o1 == null && o2 == null){
      return 0;
    }else if(o2 == null){
      return -1;
    }else if(o1 == null){
      return 1;
    }

    return Collator.getInstance(Locale.US)
      .compare(o1.getCompletion(), o2.getCompletion());
  }

  /**
   * {@inheritDoc}
   */
  public boolean equals(Object obj)
  {
    if(obj instanceof CodeCompleteComparator){
      return true;
    }
    return false;
  }
}
