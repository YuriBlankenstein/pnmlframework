/**
 *  Copyright 2009-2016 Université Paris Ouest and Sorbonne Universités,
							Univ. Paris 06 - CNRS UMR 7606 (LIP6)
 *
 *  All rights reserved.   This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  Project leader / Initial Contributor:
 *    Lom Messan Hillah - <lom-messan.hillah@lip6.fr>
 *
 *  Contributors:
 *    ${ocontributors} - <$oemails}>
 *
 *  Mailing list:
 *    lom-messan.hillah@lip6.fr
 */
/**
 * (C) Sorbonne Universités, UPMC Univ Paris 06, UMR CNRS 7606 (LIP6/MoVe)
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors: 
 *    Lom HILLAH (LIP6) - Initial models and implementation
 *    Rachid Alahyane (UPMC) - Infrastructure and continuous integration
 *    Bastien Bouzerau (UPMC) - Architecture 
 *    Guillaume Giffo (UPMC) - Code generation refactoring, High-level API
 */
package fr.lip6.move.pnml.pthlpng.hlcorestructure;

import java.nio.channels.FileChannel;
import java.util.List;

import org.apache.axiom.om.OMElement;
import org.eclipse.emf.common.util.DiagnosticChain;

import fr.lip6.move.pnml.framework.utils.IdRefLinker;
import fr.lip6.move.pnml.framework.utils.exception.InnerBuildException;
import fr.lip6.move.pnml.framework.utils.exception.InvalidIDException;
import fr.lip6.move.pnml.framework.utils.exception.VoidRepositoryException;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Place
 * Node</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link fr.lip6.move.pnml.pthlpng.hlcorestructure.PlaceNode#getReferencingPlaces
 * <em>Referencing Places</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.lip6.move.pnml.pthlpng.hlcorestructure.HlcorestructurePackage#getPlaceNode()
 * @model abstract="true" annotation="http://www.pnml.org/models/HLAPI"
 * @generated
 */
public interface PlaceNode extends Node {
	/**
	 * Returns the value of the '<em><b>Referencing Places</b></em>' reference list.
	 * The list contents are of type
	 * {@link fr.lip6.move.pnml.pthlpng.hlcorestructure.RefPlace}. It is
	 * bidirectional and its opposite is
	 * '{@link fr.lip6.move.pnml.pthlpng.hlcorestructure.RefPlace#getRef
	 * <em>Ref</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referencing Places</em>' reference list isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Referencing Places</em>' reference list.
	 * @see fr.lip6.move.pnml.pthlpng.hlcorestructure.HlcorestructurePackage#getPlaceNode_ReferencingPlaces()
	 * @see fr.lip6.move.pnml.pthlpng.hlcorestructure.RefPlace#getRef
	 * @model opposite="ref" changeable="false"
	 * @generated
	 */
	List<RefPlace> getReferencingPlaces();

	@Override
	public abstract String toPNML();

	@Override
	public abstract void fromPNML(OMElement locRoot, IdRefLinker idr)
			throws InnerBuildException, InvalidIDException, VoidRepositoryException;

	@Override
	public abstract void toPNML(FileChannel fc);

	@Override
	public abstract boolean validateOCL(DiagnosticChain diagnostics);
} // PlaceNode
