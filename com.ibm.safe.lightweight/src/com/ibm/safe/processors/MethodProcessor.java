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
/*
 * Created on Jan 22, 2005
 */
package com.ibm.safe.processors;

import com.ibm.wala.classLoader.IClass;
import com.ibm.wala.classLoader.IMethod;
import com.ibm.wala.util.CancelException;

/**
 * @author Eran Yahav (yahave)
 * 
 */
public interface MethodProcessor {
  public void processProlog(IMethod method);

  public void process(IMethod method) throws CancelException;

  public void processEpilog(IMethod method);

  public Object getResult();

  public void addInstructionProcessor(InstructionProcessor ip);

  public void setup(IClass klass, Object context);

}