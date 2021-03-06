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
package fr.lip6.move.pnml.hlpn.hlcorestructure;

import java.nio.channels.FileChannel;
import java.util.List;

import org.apache.axiom.om.OMElement;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EObject;

import fr.lip6.move.pnml.framework.utils.IdRefLinker;
import fr.lip6.move.pnml.framework.utils.exception.InnerBuildException;
import fr.lip6.move.pnml.framework.utils.exception.InvalidIDException;
import fr.lip6.move.pnml.framework.utils.exception.VoidRepositoryException;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Petri Net</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.lip6.move.pnml.hlpn.hlcorestructure.PetriNet#getId <em>Id</em>}</li>
 *   <li>{@link fr.lip6.move.pnml.hlpn.hlcorestructure.PetriNet#getType <em>Type</em>}</li>
 *   <li>{@link fr.lip6.move.pnml.hlpn.hlcorestructure.PetriNet#getPages <em>Pages</em>}</li>
 *   <li>{@link fr.lip6.move.pnml.hlpn.hlcorestructure.PetriNet#getName <em>Name</em>}</li>
 *   <li>{@link fr.lip6.move.pnml.hlpn.hlcorestructure.PetriNet#getToolspecifics <em>Toolspecifics</em>}</li>
 *   <li>{@link fr.lip6.move.pnml.hlpn.hlcorestructure.PetriNet#getContainerPetriNetDoc <em>Container Petri Net Doc</em>}</li>
 *   <li>{@link fr.lip6.move.pnml.hlpn.hlcorestructure.PetriNet#getDeclaration <em>Declaration</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.lip6.move.pnml.hlpn.hlcorestructure.HlcorestructurePackage#getPetriNet()
 * @model annotation="http://www.pnml.org/models/ToPNML kind='son' tag='net'"
 * @generated
 */
public interface PetriNet extends EObject {
	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see fr.lip6.move.pnml.hlpn.hlcorestructure.HlcorestructurePackage#getPetriNet_Id()
	 * @model default="" id="true" required="true" ordered="false"
	 *        annotation="http://www.pnml.org/models/ToPNML tag='id' kind='id'"
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link fr.lip6.move.pnml.hlpn.hlcorestructure.PetriNet#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The default value is <code>"http://www.pnml.org/version-2009/grammar/highlevelnet"</code>.
	 * The literals are from the enumeration {@link fr.lip6.move.pnml.hlpn.hlcorestructure.PNType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see fr.lip6.move.pnml.hlpn.hlcorestructure.PNType
	 * @see #setType(PNType)
	 * @see fr.lip6.move.pnml.hlpn.hlcorestructure.HlcorestructurePackage#getPetriNet_Type()
	 * @model default="http://www.pnml.org/version-2009/grammar/highlevelnet" required="true" ordered="false"
	 *        annotation="http://www.pnml.org/models/ToPNML tag='type' kind='attribute'"
	 * @generated
	 */
	PNType getType();

	/**
	 * Sets the value of the '{@link fr.lip6.move.pnml.hlpn.hlcorestructure.PetriNet#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see fr.lip6.move.pnml.hlpn.hlcorestructure.PNType
	 * @see #getType()
	 * @generated
	 */
	void setType(PNType value);

	/**
	 * Returns the value of the '<em><b>Pages</b></em>' containment reference list.
	 * The list contents are of type {@link fr.lip6.move.pnml.hlpn.hlcorestructure.Page}.
	 * It is bidirectional and its opposite is '{@link fr.lip6.move.pnml.hlpn.hlcorestructure.Page#getContainerPetriNet <em>Container Petri Net</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pages</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pages</em>' containment reference list.
	 * @see fr.lip6.move.pnml.hlpn.hlcorestructure.HlcorestructurePackage#getPetriNet_Pages()
	 * @see fr.lip6.move.pnml.hlpn.hlcorestructure.Page#getContainerPetriNet
	 * @model opposite="containerPetriNet" containment="true" required="true" ordered="false"
	 *        annotation="http://www.pnml.org/models/ToPNML kind='follow'"
	 * @generated
	 */
	List<Page> getPages();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link fr.lip6.move.pnml.hlpn.hlcorestructure.Name#getContainerNamePetriNet <em>Container Name Petri Net</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' containment reference.
	 * @see #setName(Name)
	 * @see fr.lip6.move.pnml.hlpn.hlcorestructure.HlcorestructurePackage#getPetriNet_Name()
	 * @see fr.lip6.move.pnml.hlpn.hlcorestructure.Name#getContainerNamePetriNet
	 * @model opposite="containerNamePetriNet" containment="true" ordered="false"
	 *        annotation="http://www.pnml.org/models/ToPNML kind='follow'"
	 * @generated
	 */
	Name getName();

	/**
	 * Sets the value of the '{@link fr.lip6.move.pnml.hlpn.hlcorestructure.PetriNet#getName <em>Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' containment reference.
	 * @see #getName()
	 * @generated
	 */
	void setName(Name value);

	/**
	 * Returns the value of the '<em><b>Toolspecifics</b></em>' containment reference list.
	 * The list contents are of type {@link fr.lip6.move.pnml.hlpn.hlcorestructure.ToolInfo}.
	 * It is bidirectional and its opposite is '{@link fr.lip6.move.pnml.hlpn.hlcorestructure.ToolInfo#getContainerPetriNet <em>Container Petri Net</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Toolspecifics</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Toolspecifics</em>' containment reference list.
	 * @see fr.lip6.move.pnml.hlpn.hlcorestructure.HlcorestructurePackage#getPetriNet_Toolspecifics()
	 * @see fr.lip6.move.pnml.hlpn.hlcorestructure.ToolInfo#getContainerPetriNet
	 * @model opposite="containerPetriNet" containment="true" ordered="false"
	 *        annotation="http://www.pnml.org/models/ToPNML kind='follow'"
	 * @generated
	 */
	List<ToolInfo> getToolspecifics();

	/**
	 * Returns the value of the '<em><b>Container Petri Net Doc</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link fr.lip6.move.pnml.hlpn.hlcorestructure.PetriNetDoc#getNets <em>Nets</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Container Petri Net Doc</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Container Petri Net Doc</em>' container reference.
	 * @see #setContainerPetriNetDoc(PetriNetDoc)
	 * @see fr.lip6.move.pnml.hlpn.hlcorestructure.HlcorestructurePackage#getPetriNet_ContainerPetriNetDoc()
	 * @see fr.lip6.move.pnml.hlpn.hlcorestructure.PetriNetDoc#getNets
	 * @model opposite="nets" required="true" transient="false" ordered="false"
	 * @generated
	 */
	PetriNetDoc getContainerPetriNetDoc();

	/**
	 * Sets the value of the '{@link fr.lip6.move.pnml.hlpn.hlcorestructure.PetriNet#getContainerPetriNetDoc <em>Container Petri Net Doc</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Container Petri Net Doc</em>' container reference.
	 * @see #getContainerPetriNetDoc()
	 * @generated
	 */
	void setContainerPetriNetDoc(PetriNetDoc value);

	/**
	 * Returns the value of the '<em><b>Declaration</b></em>' containment reference list.
	 * The list contents are of type {@link fr.lip6.move.pnml.hlpn.hlcorestructure.Declaration}.
	 * It is bidirectional and its opposite is '{@link fr.lip6.move.pnml.hlpn.hlcorestructure.Declaration#getContainerDeclarationPetriNet <em>Container Declaration Petri Net</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Declaration</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Declaration</em>' containment reference list.
	 * @see fr.lip6.move.pnml.hlpn.hlcorestructure.HlcorestructurePackage#getPetriNet_Declaration()
	 * @see fr.lip6.move.pnml.hlpn.hlcorestructure.Declaration#getContainerDeclarationPetriNet
	 * @model opposite="containerDeclarationPetriNet" containment="true"
	 *        annotation="http://www.pnml.org/models/ToPNML kind='follow'"
	 * @generated
	 */
	List<Declaration> getDeclaration();

	/**
	 * Return the string containing the pnml output
	 */
	public String toPNML();

	/**
	 * set values to conform PNML document
	 */
	public void fromPNML(OMElement subRoot, IdRefLinker idr) throws InnerBuildException, InvalidIDException,
			VoidRepositoryException;

	/**
	 * Write the PNML xml tree of this object into file
	 */
	public void toPNML(FileChannel fc);

	public boolean validateOCL(DiagnosticChain diagnostics);
} // PetriNet
