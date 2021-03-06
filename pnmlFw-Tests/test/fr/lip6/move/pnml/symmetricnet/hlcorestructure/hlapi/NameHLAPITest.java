/**
 * (C) Sorbonne Universités, UPMC Univ Paris 06, UMR CNRS 7606 (LIP6)
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
 *
 * $Id ggiffo, Thu Feb 11 16:29:02 CET 2016$
 */
package fr.lip6.move.pnml.symmetricnet.hlcorestructure.hlapi;

import fr.lip6.move.pnml.symmetricnet.booleans.And;
import fr.lip6.move.pnml.symmetricnet.booleans.Bool;
import fr.lip6.move.pnml.symmetricnet.booleans.BooleanConstant;
import fr.lip6.move.pnml.symmetricnet.booleans.Equality;
import fr.lip6.move.pnml.symmetricnet.booleans.Imply;
import fr.lip6.move.pnml.symmetricnet.booleans.Inequality;
import fr.lip6.move.pnml.symmetricnet.booleans.Not;
import fr.lip6.move.pnml.symmetricnet.booleans.Or;

import fr.lip6.move.pnml.symmetricnet.booleans.impl.BooleansFactoryImpl;

import fr.lip6.move.pnml.symmetricnet.cyclicEnumerations.CyclicEnumeration;
import fr.lip6.move.pnml.symmetricnet.cyclicEnumerations.Predecessor;
import fr.lip6.move.pnml.symmetricnet.cyclicEnumerations.Successor;

import fr.lip6.move.pnml.symmetricnet.cyclicEnumerations.impl.CyclicEnumerationsFactoryImpl;

import fr.lip6.move.pnml.symmetricnet.dots.Dot;
import fr.lip6.move.pnml.symmetricnet.dots.DotConstant;

import fr.lip6.move.pnml.symmetricnet.dots.impl.DotsFactoryImpl;

import fr.lip6.move.pnml.symmetricnet.finiteEnumerations.FEConstant;
import fr.lip6.move.pnml.symmetricnet.finiteEnumerations.FiniteEnumeration;

import fr.lip6.move.pnml.symmetricnet.finiteEnumerations.impl.FiniteEnumerationsFactoryImpl;

import fr.lip6.move.pnml.symmetricnet.finiteIntRanges.FiniteIntRange;
import fr.lip6.move.pnml.symmetricnet.finiteIntRanges.FiniteIntRangeConstant;
import fr.lip6.move.pnml.symmetricnet.finiteIntRanges.GreaterThan;
import fr.lip6.move.pnml.symmetricnet.finiteIntRanges.GreaterThanOrEqual;
import fr.lip6.move.pnml.symmetricnet.finiteIntRanges.LessThan;
import fr.lip6.move.pnml.symmetricnet.finiteIntRanges.LessThanOrEqual;

import fr.lip6.move.pnml.symmetricnet.finiteIntRanges.impl.FiniteIntRangesFactoryImpl;

import fr.lip6.move.pnml.symmetricnet.hlcorestructure.AnnotationGraphics;
import fr.lip6.move.pnml.symmetricnet.hlcorestructure.Condition;
import fr.lip6.move.pnml.symmetricnet.hlcorestructure.Declaration;
import fr.lip6.move.pnml.symmetricnet.hlcorestructure.HLAnnotation;
import fr.lip6.move.pnml.symmetricnet.hlcorestructure.HLMarking;
import fr.lip6.move.pnml.symmetricnet.hlcorestructure.Name;
import fr.lip6.move.pnml.symmetricnet.hlcorestructure.NodeGraphics;
import fr.lip6.move.pnml.symmetricnet.hlcorestructure.PNType;
import fr.lip6.move.pnml.symmetricnet.hlcorestructure.Page;
import fr.lip6.move.pnml.symmetricnet.hlcorestructure.PetriNet;
import fr.lip6.move.pnml.symmetricnet.hlcorestructure.PetriNetDoc;
import fr.lip6.move.pnml.symmetricnet.hlcorestructure.PnObject;
import fr.lip6.move.pnml.symmetricnet.hlcorestructure.ToolInfo;
import fr.lip6.move.pnml.symmetricnet.hlcorestructure.Type;

import fr.lip6.move.pnml.symmetricnet.hlcorestructure.impl.HlcorestructureFactoryImpl;

import fr.lip6.move.pnml.symmetricnet.integers.impl.IntegersFactoryImpl;

import fr.lip6.move.pnml.symmetricnet.multisets.All;
import fr.lip6.move.pnml.symmetricnet.multisets.Empty;

import fr.lip6.move.pnml.symmetricnet.multisets.impl.MultisetsFactoryImpl;

import fr.lip6.move.pnml.symmetricnet.partitions.Partition;
import fr.lip6.move.pnml.symmetricnet.partitions.PartitionElement;

import fr.lip6.move.pnml.symmetricnet.partitions.impl.PartitionsFactoryImpl;

import fr.lip6.move.pnml.symmetricnet.terms.Declarations;
import fr.lip6.move.pnml.symmetricnet.terms.MultisetSort;
import fr.lip6.move.pnml.symmetricnet.terms.NamedOperator;
import fr.lip6.move.pnml.symmetricnet.terms.NamedSort;
import fr.lip6.move.pnml.symmetricnet.terms.Operator;
import fr.lip6.move.pnml.symmetricnet.terms.ProductSort;
import fr.lip6.move.pnml.symmetricnet.terms.Sort;
import fr.lip6.move.pnml.symmetricnet.terms.Term;
import fr.lip6.move.pnml.symmetricnet.terms.VariableDecl;

import fr.lip6.move.pnml.symmetricnet.terms.impl.TermsFactoryImpl;

import java.util.List;

import  fr.lip6.move.pnml.framework.hlapi.*;
import fr.lip6.move.pnml.symmetricnet.booleans.hlapi.*;
import fr.lip6.move.pnml.symmetricnet.cyclicEnumerations.hlapi.*;
import fr.lip6.move.pnml.symmetricnet.dots.hlapi.*;
import fr.lip6.move.pnml.symmetricnet.finiteEnumerations.hlapi.*;
import fr.lip6.move.pnml.symmetricnet.finiteIntRanges.hlapi.*;
import fr.lip6.move.pnml.symmetricnet.hlcorestructure.hlapi.*;
import fr.lip6.move.pnml.symmetricnet.integers.hlapi.*;
import fr.lip6.move.pnml.symmetricnet.multisets.hlapi.*;
import fr.lip6.move.pnml.symmetricnet.partitions.hlapi.*;
import fr.lip6.move.pnml.symmetricnet.terms.hlapi.*;

import java.util.ArrayList;
import java.util.List;
import org.apache.axiom.om.*;
import fr.lip6.move.pnml.framework.utils.IdRefLinker;
import org.eclipse.emf.common.util.DiagnosticChain;
import fr.lip6.move.pnml.symmetricnet.hlcorestructure.*;
import fr.lip6.move.pnml.symmetricnet.hlcorestructure.impl.*;
import fr.lip6.move.pnml.framework.utils.exception.InnerBuildException;
import fr.lip6.move.pnml.framework.utils.exception.InvalidIDException;
import fr.lip6.move.pnml.framework.utils.exception.VoidRepositoryException;
import fr.lip6.move.pnml.framework.utils.IdRepository;
import fr.lip6.move.pnml.framework.utils.ModelRepository;
import org.testng.annotations.*;
public class NameHLAPITest {

	
	private AnnotationGraphicsHLAPI itemannotationgraphics;
		
	private String itemtext;
		
	
	private PetriNetHLAPI itemcontainerNamePetriNet;
	
	private PnObjectHLAPI itemcontainerNamePnObject;
	


	@AfterTest(groups = { "NameHLAPI", "hlapi" })
	public void After() {
	    System.out.println("done for "+"NameHLAPI(hlcorestructure)");
	}


	@BeforeMethod(groups = { "NameHLAPI", "hlapi" })
	public void setup() throws Exception{
	//ModelRepository.reset(); ModelRepository.getInstance().createDocumentWorkspace("void");
	ModelRepository mr = ModelRepository.getInstance();
	mr.createDocumentWorkspace("void");
	
			
			//HlcorestructureFactoryImpl
			itemannotationgraphics = new AnnotationGraphicsHLAPI(new HlcorestructureFactoryImpl().createAnnotationGraphics());
			
		
			itemtext = new String("unid");
			

	
		
		itemcontainerNamePetriNet = new PetriNetHLAPI(new HlcorestructureFactoryImpl().createPetriNet());
		
	
		
			
			
		itemcontainerNamePnObject = new fr.lip6.move.pnml.symmetricnet.hlcorestructure.hlapi.PageHLAPI(
		   new HlcorestructureFactoryImpl().createPage()
		);
			
		
	
	}

	/**
	 * this constructor allows you to set all 'settable' values
	 * excepted container.
	 */
	@Test(groups = { "hlapi", "NameHLAPI"}, dependsOnMethods={"NameHLAPI_LLAPI"})
	public void NameHLAPI_1(){//BEGIN CONSTRUCTOR BODY
   @SuppressWarnings("unused")
	NameHLAPI totest = new NameHLAPI(
		itemannotationgraphics
		,	
		itemtext
	);
	
	
	
	assert totest.getAnnotationgraphics().equals(itemannotationgraphics.getContainedItem());
	
	
	
	assert totest.getText().equals(itemtext);
	
	
	}

	/**
	 * this constructor allows you to set all 'settable' values, including container if any.
	 */
	@Test(groups = { "hlapi", "NameHLAPI"}, dependsOnMethods={"NameHLAPI_LLAPI"})
	public void NameHLAPI_2_containerNamePetriNet(){//BEGIN CONSTRUCTOR BODY

	NameHLAPI totest = new NameHLAPI(
		itemannotationgraphics
		,	
		itemtext
	,	
		itemcontainerNamePetriNet
	);
	
	
		
			assert totest.getAnnotationgraphics().equals(itemannotationgraphics.getContainedItem());
		
	
	
			assert totest.getText().equals(itemtext);
		
	
	assert totest.getContainerNamePetriNet().equals(itemcontainerNamePetriNet.getContainedItem());
	}
	/**
	 * this constructor allows you to set all 'settable' values, including container if any.
	 */
	@Test(groups = { "hlapi", "NameHLAPI"}, dependsOnMethods={"NameHLAPI_LLAPI"})
	public void NameHLAPI_2_containerNamePnObject(){//BEGIN CONSTRUCTOR BODY

	NameHLAPI totest = new NameHLAPI(
		itemannotationgraphics
		,	
		itemtext
	,	
		itemcontainerNamePnObject
	);
	
	
		
			assert totest.getAnnotationgraphics().equals(itemannotationgraphics.getContainedItem());
		
	
	
			assert totest.getText().equals(itemtext);
		
	
	assert totest.getContainerNamePnObject().equals(itemcontainerNamePnObject.getContainedItem());
	}

	/**
    * This constructor give access to required stuff only (not container if any)
    */
   @Test(groups = { "hlapi", "NameHLAPI"}, dependsOnMethods={"NameHLAPI_LLAPI"})
	public void NameHLAPI_3(){//BEGIN CONSTRUCTOR BODY

	NameHLAPI totest = new NameHLAPI(
		itemtext
	);

	
	
			assert totest.getText().equals(itemtext);
		
	
	}

	/**
    * This constructor give access to required stuff only (and container)
    */
   @Test(groups = { "hlapi", "NameHLAPI"}, dependsOnMethods={"NameHLAPI_LLAPI"})
	public void NameHLAPI_4_containerNamePetriNet(){//BEGIN CONSTRUCTOR BODY

	NameHLAPI totest = new NameHLAPI(
		itemtext
	,	
	  itemcontainerNamePetriNet
	);

	
	
			assert totest.getText().equals(itemtext);
		
	
	assert totest.getContainerNamePetriNet().equals(itemcontainerNamePetriNet.getContainedItem());
	}
	/**
    * This constructor give access to required stuff only (and container)
    */
   @Test(groups = { "hlapi", "NameHLAPI"}, dependsOnMethods={"NameHLAPI_LLAPI"})
	public void NameHLAPI_4_containerNamePnObject(){//BEGIN CONSTRUCTOR BODY

	NameHLAPI totest = new NameHLAPI(
		itemtext
	,	
	  itemcontainerNamePnObject
	);

	
	
			assert totest.getText().equals(itemtext);
		
	
	assert totest.getContainerNamePnObject().equals(itemcontainerNamePnObject.getContainedItem());
	}


	/**
	 * This constructor encapsulate a low level API object in HLAPI.
	 */
	@Test(groups = { "hlapi", "NameHLAPI"})
	public void NameHLAPI_LLAPI(){
	   Name llapi = new HlcorestructureFactoryImpl().createName();
	   fr.lip6.move.pnml.symmetricnet.hlcorestructure.hlapi.NameHLAPI hlapi = new NameHLAPI(llapi);
		assert hlapi.getContainedItem().equals(llapi);
	}

	//getters giving HLAPI object
	

	
		/**
		 * This test add a random number of desired objet in the list or of one of each existing subtypes.
		 * then test how many objet are retuned and if any exist inthe original list.
		 */
		@Test(groups = { "hlapi", "NameHLAPI"})
		public void getToolspecificsHLAPITest(){
			Name llapi = new HlcorestructureFactoryImpl().createName();
			int howmany;
			
			howmany = (int)(Math.random()*10);
			for(int i =0; i<howmany;i++)
			llapi.getToolspecifics().add(new HlcorestructureFactoryImpl().createToolInfo());
			

			NameHLAPI elem = new NameHLAPI(llapi);
			List<ToolInfoHLAPI> totest = elem.getToolspecificsHLAPI();

			assert totest.size() == howmany;

			for (ToolInfoHLAPI unit : totest) {
             assert llapi.getToolspecifics().contains(unit.getContainedItem()) : "missing element";
         }
		}
	
	

	
		
		/**
		 * This accessor automatically encapsulate an element of the current object.
		 * WARNING : this creates a new object in memory.
		 * @return : null if the element is null
		 */
		@Test(groups = { "hlapi", "NameHLAPI"})
		public void getAnnotationgraphicsHLAPITest(){
			NameHLAPI elem = new NameHLAPI(new HlcorestructureFactoryImpl().createName());

			
				elem.setAnnotationgraphicsHLAPI(itemannotationgraphics);
				AnnotationGraphicsHLAPI totest = elem.getAnnotationgraphicsHLAPI();
				assert totest.getContainedItem().equals(elem.getAnnotationgraphics());
			
		}
	
	
	

	
		
		/**
		 * This accessor automatically encapsulate an element of the current object.
		 * WARNING : this creates a new object in memory.
		 * @return : null if the element is null
		 */
		@Test(groups = { "hlapi", "NameHLAPI"})
		public void getContainerNamePetriNetHLAPITest(){
			NameHLAPI elem = new NameHLAPI(new HlcorestructureFactoryImpl().createName());

			
				elem.setContainerNamePetriNetHLAPI(itemcontainerNamePetriNet);
				PetriNetHLAPI totest = elem.getContainerNamePetriNetHLAPI();
				assert totest.getContainedItem().equals(elem.getContainerNamePetriNet());
			
		}
	
	

	
		
		/**
		 * This accessor automatically encapsulate an element of the current object.
		 * WARNING : this creates a new object in memory.
		 * @return : null if the element is null
		 */
		@Test(groups = { "hlapi", "NameHLAPI"})
		public void getContainerNamePnObjectHLAPITest(){
			NameHLAPI elem = new NameHLAPI(new HlcorestructureFactoryImpl().createName());

			
				elem.setContainerNamePnObjectHLAPI(new fr.lip6.move.pnml.symmetricnet.hlcorestructure.hlapi.PageHLAPI(new HlcorestructureFactoryImpl().createPage()));
				PnObjectHLAPI totest_hlcorestructure_Page = elem.getContainerNamePnObjectHLAPI();
				assert totest_hlcorestructure_Page.getContainedItem().equals(elem.getContainerNamePnObject());
			
				elem.setContainerNamePnObjectHLAPI(new fr.lip6.move.pnml.symmetricnet.hlcorestructure.hlapi.ArcHLAPI(new HlcorestructureFactoryImpl().createArc()));
				PnObjectHLAPI totest_hlcorestructure_Arc = elem.getContainerNamePnObjectHLAPI();
				assert totest_hlcorestructure_Arc.getContainedItem().equals(elem.getContainerNamePnObject());
			
				elem.setContainerNamePnObjectHLAPI(new fr.lip6.move.pnml.symmetricnet.hlcorestructure.hlapi.PlaceHLAPI(new HlcorestructureFactoryImpl().createPlace()));
				PnObjectHLAPI totest_hlcorestructure_Place = elem.getContainerNamePnObjectHLAPI();
				assert totest_hlcorestructure_Place.getContainedItem().equals(elem.getContainerNamePnObject());
			
				elem.setContainerNamePnObjectHLAPI(new fr.lip6.move.pnml.symmetricnet.hlcorestructure.hlapi.RefTransitionHLAPI(new HlcorestructureFactoryImpl().createRefTransition()));
				PnObjectHLAPI totest_hlcorestructure_RefTransition = elem.getContainerNamePnObjectHLAPI();
				assert totest_hlcorestructure_RefTransition.getContainedItem().equals(elem.getContainerNamePnObject());
			
				elem.setContainerNamePnObjectHLAPI(new fr.lip6.move.pnml.symmetricnet.hlcorestructure.hlapi.TransitionHLAPI(new HlcorestructureFactoryImpl().createTransition()));
				PnObjectHLAPI totest_hlcorestructure_Transition = elem.getContainerNamePnObjectHLAPI();
				assert totest_hlcorestructure_Transition.getContainedItem().equals(elem.getContainerNamePnObject());
			
				elem.setContainerNamePnObjectHLAPI(new fr.lip6.move.pnml.symmetricnet.hlcorestructure.hlapi.RefPlaceHLAPI(new HlcorestructureFactoryImpl().createRefPlace()));
				PnObjectHLAPI totest_hlcorestructure_RefPlace = elem.getContainerNamePnObjectHLAPI();
				assert totest_hlcorestructure_RefPlace.getContainedItem().equals(elem.getContainerNamePnObject());
			
		}
	

	//Special getter for list of generics object, return only one object type.
	
	
	
	
	

	//setters/remover for lists.
	
	@Test(groups = { "hlapi", "NameHLAPI"})
	public void addToolspecificsHLAPITest(){
		NameHLAPI elem = new NameHLAPI(new HlcorestructureFactoryImpl().createName());
		int howmany = (int)(Math.random()*10);
		for(int i =0; i<howmany;i++)
			
			elem.addToolspecificsHLAPI(new ToolInfoHLAPI(new HlcorestructureFactoryImpl().createToolInfo()));
			

		assert elem.getContainedItem().getToolspecifics().size() == howmany;
	}

	@Test(groups = { "hlapi", "NameHLAPI"})
	public void removeToolspecificsTest(){
		NameHLAPI elem = new NameHLAPI(new HlcorestructureFactoryImpl().createName());
		int howmany = (int)(Math.random()*10);
		int howdiff = (int)(Math.random()*10);

			
			ToolInfoHLAPI sav;

		for(int i =0; i<(howmany);i++)
			
			elem.addToolspecificsHLAPI(new ToolInfoHLAPI(new HlcorestructureFactoryImpl().createToolInfo()));
			


		
		sav = new ToolInfoHLAPI(new HlcorestructureFactoryImpl().createToolInfo());
		

		elem.addToolspecificsHLAPI(sav);
		assert elem.getContainedItem().getToolspecifics().size() == howmany+1;

		for(int i =0; i<(howdiff);i++)
			
			elem.addToolspecificsHLAPI(new ToolInfoHLAPI(new HlcorestructureFactoryImpl().createToolInfo()));
			


		elem.removeToolspecificsHLAPI(sav);

		assert elem.getContainedItem().getToolspecifics().size() == howmany+howdiff;
	}
	

	@Test(groups = { "hlapi", "NameHLAPI"})
	public void equalsTest(){
		Name a = new HlcorestructureFactoryImpl().createName();
		Name b = new HlcorestructureFactoryImpl().createName();
		NameHLAPI aprime = new NameHLAPI(a);
		NameHLAPI asecond = new NameHLAPI(a);
		NameHLAPI bprime = new NameHLAPI(b);

		assert aprime.equals(asecond);
		assert !aprime.equals(bprime);
	}

	//cloning method
	//public NameHLAPI clone(){
	//	return new NameHLAPI(this);
	//}

	//PNML
	
	/**
	 * return the PNML xml tree for this object.
	 */
	//public String toPNML(){
		//return item.toPNML();
	//}

	/**
	 * creates an object from the xml nodes.(symetric work of toPNML)
	 */
	//public void fromPNML(OMElement subRoot,IdRefLinker idr) throws InnerBuildException, InvalidIDException, VoidRepositoryException{
		//item.fromPNML(subRoot,idr);
	//}
	
}
