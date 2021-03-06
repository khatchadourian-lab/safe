/*******************************************************************************
 * Copyright (c) 2004-2010 IBM Corporation.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package j2se.typestate.file;

public class Test4 {

  public static void main(String[] args) {

    FileHolder x;
    FileHolder y = new FileHolder();
    FileHolder z = new FileHolder();
    FileHolder w = new FileHolder();

    FileComponent f = new FileComponent();
    FileHolder h1 = new FileHolder();
    h1.file = f;
    x = h1;
    for (int i = 0; i < 42; i++) {
      y = new FileHolder();
      y.holder = x;
      x = y;
    }

    f = new FileComponent();
    FileHolder h2 = new FileHolder();
    h2.file = f;

    x = h2;
    for (int i = 0; i < 42; i++) {
      z = new FileHolder();
      z.holder = x;
      x = z;
    }

    f = new FileComponent();
    FileHolder h3 = new FileHolder();
    h3.file = f;

    x = h3;
    for (int i = 0; i < 42; i++) {
      w = new FileHolder();
      w.holder = x;
      x = w;
    }

    FileHolder href = z;
    FileComponent fref = z.file;
    while (fref == null && href != null) {
      href = href.holder;
      fref = href.file;
    }

    fref.close();

    href = w;
    fref = w.file;
    while (fref == null && href != null) {
      href = href.holder;
      fref = href.file;
    }

    fref.close();

    href = y;
    FileComponent fref2 = y.file;
    while (fref2 == null && href != null) {
      href = href.holder;
      fref2 = href.file;
    }

    fref2.read();

    // a use of fref so I can see both fref and fref2 on the same config
    FileComponent dummyRef = fref;

  }
}
