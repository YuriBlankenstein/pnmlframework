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
 * $Id ggiffo, Thu Feb 11 16:29:58 CET 2016$
 */
package fr.lip6.move.pnml.hlpn.hlcorestructure.hlapi;

import fr.lip6.move.pnml.hlpn.arbitrarydeclarations.AnySort;
import fr.lip6.move.pnml.hlpn.arbitrarydeclarations.ArbitraryOperator;
import fr.lip6.move.pnml.hlpn.arbitrarydeclarations.ArbitrarySort;
import fr.lip6.move.pnml.hlpn.arbitrarydeclarations.Unparsed;

import fr.lip6.move.pnml.hlpn.arbitrarydeclarations.impl.ArbitrarydeclarationsFactoryImpl;

import fr.lip6.move.pnml.hlpn.booleans.And;
import fr.lip6.move.pnml.hlpn.booleans.Bool;
import fr.lip6.move.pnml.hlpn.booleans.BooleanConstant;
import fr.lip6.move.pnml.hlpn.booleans.Equality;
import fr.lip6.move.pnml.hlpn.booleans.Imply;
import fr.lip6.move.pnml.hlpn.booleans.Inequality;
import fr.lip6.move.pnml.hlpn.booleans.Not;
import fr.lip6.move.pnml.hlpn.booleans.Or;

import fr.lip6.move.pnml.hlpn.booleans.impl.BooleansFactoryImpl;

import fr.lip6.move.pnml.hlpn.cyclicEnumerations.CyclicEnumeration;
import fr.lip6.move.pnml.hlpn.cyclicEnumerations.Predecessor;
import fr.lip6.move.pnml.hlpn.cyclicEnumerations.Successor;

import fr.lip6.move.pnml.hlpn.cyclicEnumerations.impl.CyclicEnumerationsFactoryImpl;

import fr.lip6.move.pnml.hlpn.dots.Dot;
import fr.lip6.move.pnml.hlpn.dots.DotConstant;

import fr.lip6.move.pnml.hlpn.dots.impl.DotsFactoryImpl;

import fr.lip6.move.pnml.hlpn.finiteEnumerations.FEConstant;
import fr.lip6.move.pnml.hlpn.finiteEnumerations.FiniteEnumeration;

import fr.lip6.move.pnml.hlpn.finiteEnumerations.impl.FiniteEnumerationsFactoryImpl;

import fr.lip6.move.pnml.hlpn.finiteIntRanges.FiniteIntRange;
import fr.lip6.move.pnml.hlpn.finiteIntRanges.FiniteIntRangeConstant;
import fr.lip6.move.pnml.hlpn.finiteIntRanges.GreaterThan;
import fr.lip6.move.pnml.hlpn.finiteIntRanges.GreaterThanOrEqual;
import fr.lip6.move.pnml.hlpn.finiteIntRanges.LessThan;
import fr.lip6.move.pnml.hlpn.finiteIntRanges.LessThanOrEqual;

import fr.lip6.move.pnml.hlpn.finiteIntRanges.impl.FiniteIntRangesFactoryImpl;

import fr.lip6.move.pnml.hlpn.hlcorestructure.Annotation;
import fr.lip6.move.pnml.hlpn.hlcorestructure.AnnotationGraphics;
import fr.lip6.move.pnml.hlpn.hlcorestructure.AnyObject;
import fr.lip6.move.pnml.hlpn.hlcorestructure.Arc;
import fr.lip6.move.pnml.hlpn.hlcorestructure.ArcGraphics;
import fr.lip6.move.pnml.hlpn.hlcorestructure.CSS2Color;
import fr.lip6.move.pnml.hlpn.hlcorestructure.Condition;
import fr.lip6.move.pnml.hlpn.hlcorestructure.Declaration;
import fr.lip6.move.pnml.hlpn.hlcorestructure.Dimension;
import fr.lip6.move.pnml.hlpn.hlcorestructure.Fill;
import fr.lip6.move.pnml.hlpn.hlcorestructure.Font;
import fr.lip6.move.pnml.hlpn.hlcorestructure.Gradient;
import fr.lip6.move.pnml.hlpn.hlcorestructure.HLAnnotation;
import fr.lip6.move.pnml.hlpn.hlcorestructure.HLMarking;
import fr.lip6.move.pnml.hlpn.hlcorestructure.Label;
import fr.lip6.move.pnml.hlpn.hlcorestructure.Line;
import fr.lip6.move.pnml.hlpn.hlcorestructure.LineShape;
import fr.lip6.move.pnml.hlpn.hlcorestructure.LineStyle;
import fr.lip6.move.pnml.hlpn.hlcorestructure.Name;
import fr.lip6.move.pnml.hlpn.hlcorestructure.Node;
import fr.lip6.move.pnml.hlpn.hlcorestructure.NodeGraphics;
import fr.lip6.move.pnml.hlpn.hlcorestructure.Offset;
import fr.lip6.move.pnml.hlpn.hlcorestructure.PNType;
import fr.lip6.move.pnml.hlpn.hlcorestructure.Page;
import fr.lip6.move.pnml.hlpn.hlcorestructure.PetriNet;
import fr.lip6.move.pnml.hlpn.hlcorestructure.PetriNetDoc;
import fr.lip6.move.pnml.hlpn.hlcorestructure.PnObject;
import fr.lip6.move.pnml.hlpn.hlcorestructure.Position;
import fr.lip6.move.pnml.hlpn.hlcorestructure.ToolInfo;
import fr.lip6.move.pnml.hlpn.hlcorestructure.Type;

import fr.lip6.move.pnml.hlpn.hlcorestructure.impl.HlcorestructureFactoryImpl;

import fr.lip6.move.pnml.hlpn.integers.impl.IntegersFactoryImpl;

import fr.lip6.move.pnml.hlpn.lists.EmptyList;
import fr.lip6.move.pnml.hlpn.lists.HLPNList;
import fr.lip6.move.pnml.hlpn.lists.MakeList;

import fr.lip6.move.pnml.hlpn.lists.impl.ListsFactoryImpl;

import fr.lip6.move.pnml.hlpn.multisets.All;
import fr.lip6.move.pnml.hlpn.multisets.Empty;

import fr.lip6.move.pnml.hlpn.multisets.impl.MultisetsFactoryImpl;

import fr.lip6.move.pnml.hlpn.partitions.Partition;
import fr.lip6.move.pnml.hlpn.partitions.PartitionElement;

import fr.lip6.move.pnml.hlpn.partitions.impl.PartitionsFactoryImpl;

import fr.lip6.move.pnml.hlpn.strings.impl.StringsFactoryImpl;

import fr.lip6.move.pnml.hlpn.terms.Declarations;
import fr.lip6.move.pnml.hlpn.terms.MultisetSort;
import fr.lip6.move.pnml.hlpn.terms.NamedOperator;
import fr.lip6.move.pnml.hlpn.terms.NamedSort;
import fr.lip6.move.pnml.hlpn.terms.Operator;
import fr.lip6.move.pnml.hlpn.terms.ProductSort;
import fr.lip6.move.pnml.hlpn.terms.Sort;
import fr.lip6.move.pnml.hlpn.terms.Term;
import fr.lip6.move.pnml.hlpn.terms.VariableDecl;

import fr.lip6.move.pnml.hlpn.terms.impl.TermsFactoryImpl;

import java.net.URI;

import java.util.List;

import  fr.lip6.move.pnml.framework.hlapi.*;
import fr.lip6.move.pnml.hlpn.arbitrarydeclarations.hlapi.*;
import fr.lip6.move.pnml.hlpn.booleans.hlapi.*;
import fr.lip6.move.pnml.hlpn.cyclicEnumerations.hlapi.*;
import fr.lip6.move.pnml.hlpn.dots.hlapi.*;
import fr.lip6.move.pnml.hlpn.finiteEnumerations.hlapi.*;
import fr.lip6.move.pnml.hlpn.finiteIntRanges.hlapi.*;
import fr.lip6.move.pnml.hlpn.hlcorestructure.hlapi.*;
import fr.lip6.move.pnml.hlpn.integers.hlapi.*;
import fr.lip6.move.pnml.hlpn.lists.hlapi.*;
import fr.lip6.move.pnml.hlpn.multisets.hlapi.*;
import fr.lip6.move.pnml.hlpn.partitions.hlapi.*;
import fr.lip6.move.pnml.hlpn.strings.hlapi.*;
import fr.lip6.move.pnml.hlpn.terms.hlapi.*;

import java.util.ArrayList;
import java.util.List;
import org.apache.axiom.om.*;
import fr.lip6.move.pnml.framework.utils.IdRefLinker;
import org.eclipse.emf.common.util.DiagnosticChain;
import fr.lip6.move.pnml.hlpn.hlcorestructure.*;
import fr.lip6.move.pnml.hlpn.hlcorestructure.impl.*;
import fr.lip6.move.pnml.framework.utils.exception.InnerBuildException;
import fr.lip6.move.pnml.framework.utils.exception.InvalidIDException;
import fr.lip6.move.pnml.framework.utils.exception.VoidRepositoryException;
import fr.lip6.move.pnml.framework.utils.IdRepository;
import fr.lip6.move.pnml.framework.utils.ModelRepository;
import org.testng.annotations.*;
public class ArcGraphicsHLAPITest {

	
	private LineHLAPI itemline;
		
	
	private ArcHLAPI itemcontainerArc;
	


	@AfterTest(groups = { "ArcGraphicsHLAPI", "hlapi" })
	public void After() {
	    System.out.println("done for "+"ArcGraphicsHLAPI(hlcorestructure)");
	}


	@BeforeMethod(groups = { "ArcGraphicsHLAPI", "hlapi" })
	public void setup() throws Exception{
	//ModelRepository.reset(); ModelRepository.getInstance().createDocumentWorkspace("void");
	ModelRepository mr = ModelRepository.getInstance();
	mr.createDocumentWorkspace("void");
	
			
			//HlcorestructureFactoryImpl
			itemline = new LineHLAPI(new HlcorestructureFactoryImpl().createLine());
			
		

	
		
		itemcontainerArc = new ArcHLAPI(new HlcorestructureFactoryImpl().createArc());
		
	
	}

	/**
	 * this constructor allows you to set all 'settable' values
	 * excepted container.
	 */
	@Test(groups = { "hlapi", "ArcGraphicsHLAPI"}, dependsOnMethods={"ArcGraphicsHLAPI_LLAPI"})
	public void ArcGraphicsHLAPI_1(){//BEGIN CONSTRUCTOR BODY
   @SuppressWarnings("unused")
	ArcGraphicsHLAPI totest = new ArcGraphicsHLAPI(
		itemline
	);
	
	
	
	assert totest.getLine().equals(itemline.getContainedItem());
	
	
	}

	/**
	 * this constructor allows you to set all 'settable' values, including container if any.
	 */
	@Test(groups = { "hlapi", "ArcGraphicsHLAPI"}, dependsOnMethods={"ArcGraphicsHLAPI_LLAPI"})
	public void ArcGraphicsHLAPI_2_containerArc(){//BEGIN CONSTRUCTOR BODY

	ArcGraphicsHLAPI totest = new ArcGraphicsHLAPI(
		itemline
	,	
		itemcontainerArc
	);
	
	
		
			assert totest.getLine().equals(itemline.getContainedItem());
		
	
	assert totest.getContainerArc().equals(itemcontainerArc.getContainedItem());
	}

	/**
    * This constructor give access to required stuff only (not container if any)
    */

	/**
    * This constructor give access to required stuff only (and container)
    */
   @Test(groups = { "hlapi", "ArcGraphicsHLAPI"}, dependsOnMethods={"ArcGraphicsHLAPI_LLAPI"})
	public void ArcGraphicsHLAPI_4_containerArc(){//BEGIN CONSTRUCTOR BODY

	ArcGraphicsHLAPI totest = new ArcGraphicsHLAPI(
	  itemcontainerArc
	);

	
	assert totest.getContainerArc().equals(itemcontainerArc.getContainedItem());
	}


	/**
	 * This constructor encapsulate a low level API object in HLAPI.
	 */
	@Test(groups = { "hlapi", "ArcGraphicsHLAPI"})
	public void ArcGraphicsHLAPI_LLAPI(){
	   ArcGraphics llapi = new HlcorestructureFactoryImpl().createArcGraphics();
	   fr.lip6.move.pnml.hlpn.hlcorestructure.hlapi.ArcGraphicsHLAPI hlapi = new ArcGraphicsHLAPI(llapi);
		assert hlapi.getContainedItem().equals(llapi);
	}

	//getters giving HLAPI object
	

	
		/**
		 * This test add a random number of desired objet in the list or of one of each existing subtypes.
		 * then test how many objet are retuned and if any exist inthe original list.
		 */
		@Test(groups = { "hlapi", "ArcGraphicsHLAPI"})
		public void getPositionsHLAPITest(){
			ArcGraphics llapi = new HlcorestructureFactoryImpl().createArcGraphics();
			int howmany;
			
			howmany = (int)(Math.random()*10);
			for(int i =0; i<howmany;i++)
			llapi.getPositions().add(new HlcorestructureFactoryImpl().createPosition());
			

			ArcGraphicsHLAPI elem = new ArcGraphicsHLAPI(llapi);
			List<PositionHLAPI> totest = elem.getPositionsHLAPI();

			assert totest.size() == howmany;

			for (PositionHLAPI unit : totest) {
             assert llapi.getPositions().contains(unit.getContainedItem()) : "missing element";
         }
		}
	
	

	
		
		/**
		 * This accessor automatically encapsulate an element of the current object.
		 * WARNING : this creates a new object in memory.
		 * @return : null if the element is null
		 */
		@Test(groups = { "hlapi", "ArcGraphicsHLAPI"})
		public void getLineHLAPITest(){
			ArcGraphicsHLAPI elem = new ArcGraphicsHLAPI(new HlcorestructureFactoryImpl().createArcGraphics());

			
				elem.setLineHLAPI(itemline);
				LineHLAPI totest = elem.getLineHLAPI();
				assert totest.getContainedItem().equals(elem.getLine());
			
		}
	
	

	
		
		/**
		 * This accessor automatically encapsulate an element of the current object.
		 * WARNING : this creates a new object in memory.
		 * @return : null if the element is null
		 */
		@Test(groups = { "hlapi", "ArcGraphicsHLAPI"})
		public void getContainerArcHLAPITest(){
			ArcGraphicsHLAPI elem = new ArcGraphicsHLAPI(new HlcorestructureFactoryImpl().createArcGraphics());

			
				elem.setContainerArcHLAPI(itemcontainerArc);
				ArcHLAPI totest = elem.getContainerArcHLAPI();
				assert totest.getContainedItem().equals(elem.getContainerArc());
			
		}
	

	//Special getter for list of generics object, return only one object type.
	
	
	
	

	//setters/remover for lists.
	
	@Test(groups = { "hlapi", "ArcGraphicsHLAPI"})
	public void addPositionsHLAPITest(){
		ArcGraphicsHLAPI elem = new ArcGraphicsHLAPI(new HlcorestructureFactoryImpl().createArcGraphics());
		int howmany = (int)(Math.random()*10);
		for(int i =0; i<howmany;i++)
			
			elem.addPositionsHLAPI(new PositionHLAPI(new HlcorestructureFactoryImpl().createPosition()));
			

		assert elem.getContainedItem().getPositions().size() == howmany;
	}

	@Test(groups = { "hlapi", "ArcGraphicsHLAPI"})
	public void removePositionsTest(){
		ArcGraphicsHLAPI elem = new ArcGraphicsHLAPI(new HlcorestructureFactoryImpl().createArcGraphics());
		int howmany = (int)(Math.random()*10);
		int howdiff = (int)(Math.random()*10);

			
			PositionHLAPI sav;

		for(int i =0; i<(howmany);i++)
			
			elem.addPositionsHLAPI(new PositionHLAPI(new HlcorestructureFactoryImpl().createPosition()));
			


		
		sav = new PositionHLAPI(new HlcorestructureFactoryImpl().createPosition());
		

		elem.addPositionsHLAPI(sav);
		assert elem.getContainedItem().getPositions().size() == howmany+1;

		for(int i =0; i<(howdiff);i++)
			
			elem.addPositionsHLAPI(new PositionHLAPI(new HlcorestructureFactoryImpl().createPosition()));
			


		elem.removePositionsHLAPI(sav);

		assert elem.getContainedItem().getPositions().size() == howmany+howdiff;
	}
	

	@Test(groups = { "hlapi", "ArcGraphicsHLAPI"})
	public void equalsTest(){
		ArcGraphics a = new HlcorestructureFactoryImpl().createArcGraphics();
		ArcGraphics b = new HlcorestructureFactoryImpl().createArcGraphics();
		ArcGraphicsHLAPI aprime = new ArcGraphicsHLAPI(a);
		ArcGraphicsHLAPI asecond = new ArcGraphicsHLAPI(a);
		ArcGraphicsHLAPI bprime = new ArcGraphicsHLAPI(b);

		assert aprime.equals(asecond);
		assert !aprime.equals(bprime);
	}

	//cloning method
	//public ArcGraphicsHLAPI clone(){
	//	return new ArcGraphicsHLAPI(this);
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
