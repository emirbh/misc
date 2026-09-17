package fpml.consolidated.doc;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.util.ListEquals;
import fpml.consolidated.doc.meta.TradeMeta;
import fpml.consolidated.shared.BusinessCenter;
import fpml.consolidated.shared.CalculationAgent;
import fpml.consolidated.shared.Collateral;
import fpml.consolidated.shared.Documentation;
import fpml.consolidated.shared.GoverningLaw;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.Payment;
import fpml.consolidated.shared.Product;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type defining an FpML trade.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type defining an FpML trade.
 *
 */
@RosettaDataType(value="Trade", builder=Trade.TradeBuilderImpl.class, version="2.1.1")
@RuneDataType(value="Trade", model="fpml", builder=Trade.TradeBuilderImpl.class, version="2.1.1")
public interface Trade extends RosettaModelObject {

	TradeMeta metaData = new TradeMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	String getId();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The information on the trade which is not product specific, e.g. trade date.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The information on the trade which is not product specific, e.g. trade date.
	 *
	 */
	TradeHeader getTradeHeader();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	Product getProduct();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Other fees or additional payments associated with the trade, e.g. broker commissions, where one or more of the parties involved are not principal parties involved in the trade.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Other fees or additional payments associated with the trade, e.g. broker commissions, where one or more of the parties involved are not principal parties involved in the trade.
	 *
	 */
	List<? extends Payment> getOtherPartyPayment();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Identifies that party (or parties) that brokered this trade.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Identifies that party (or parties) that brokered this trade.
	 *
	 */
	List<? extends PartyReference> getBrokerPartyReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The ISDA calculation agent responsible for performing duties as defined in the applicable product definitions.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The ISDA calculation agent responsible for performing duties as defined in the applicable product definitions.
	 *
	 */
	CalculationAgent getCalculationAgent();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The city in which the office through which ISDA Calculation Agent is acting for purposes of the transaction is located The short-form confirm for a trade that is executed under a Sovereign or Asia Pacific Master Confirmation Agreement ( MCA ), does not need to specify the Calculation Agent. However, the confirm does need to specify the Calculation Agent City. This is due to the fact that the MCA sets the value for Calculation Agent but does not set the value for Calculation Agent City.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The city in which the office through which ISDA Calculation Agent is acting for purposes of the transaction is located The short-form confirm for a trade that is executed under a Sovereign or Asia Pacific Master Confirmation Agreement ( MCA ), does not need to specify the Calculation Agent. However, the confirm does need to specify the Calculation Agent City. This is due to the fact that the MCA sets the value for Calculation Agent but does not set the value for Calculation Agent City.
	 *
	 */
	BusinessCenter getCalculationAgentBusinessCenter();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The party referenced is the ISDA Determination Party that specified in the related Confirmation as Determination Party.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The party referenced is the ISDA Determination Party that specified in the related Confirmation as Determination Party.
	 *
	 */
	List<? extends PartyReference> getDeterminingParty();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The party referenced is specified in the related Confirmation as Barrier Determination Agent.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The party referenced is specified in the related Confirmation as Barrier Determination Agent.
	 *
	 */
	PartyReference getBarrierDeterminationAgent();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The party referenced is the ISDA Hedging Party that specified in the related Confirmation as Hedging, or if no Hedging Party is specified, either party to the Transaction.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The party referenced is the ISDA Hedging Party that specified in the related Confirmation as Hedging, or if no Hedging Party is specified, either party to the Transaction.
	 *
	 */
	List<? extends PartyReference> getHedgingParty();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Defines collateral obiligations of a Party
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Defines collateral obiligations of a Party
	 *
	 */
	Collateral getCollateral();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Defines the definitions that govern the document and should include the year and type of definitions referenced, along with any relevant documentation (such as master agreement) and the date it was signed.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Defines the definitions that govern the document and should include the year and type of definitions referenced, along with any relevant documentation (such as master agreement) and the date it was signed.
	 *
	 */
	Documentation getDocumentation();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Identification of the law governing the transaction.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Identification of the law governing the transaction.
	 *
	 */
	GoverningLaw getGoverningLaw();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision "Short-form" representation of allocations in which the key block economics are stated once within the trade structure, and the allocation data is contained in this allocations structure.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision "Short-form" representation of allocations in which the key block economics are stated once within the trade structure, and the allocation data is contained in this allocations structure.
	 *
	 */
	List<? extends Allocations> getAllocations();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A container for approval states in the workflow.
	 *
	 */
	Approvals getApprovals();

	/*********************** Build Methods  ***********************/
	Trade build();
	
	Trade.TradeBuilder toBuilder();
	
	static Trade.TradeBuilder builder() {
		return new Trade.TradeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Trade> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Trade> getType() {
		return Trade.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("tradeHeader"), processor, TradeHeader.class, getTradeHeader());
		processRosetta(path.newSubPath("product"), processor, Product.class, getProduct());
		processRosetta(path.newSubPath("otherPartyPayment"), processor, Payment.class, getOtherPartyPayment());
		processRosetta(path.newSubPath("brokerPartyReference"), processor, PartyReference.class, getBrokerPartyReference());
		processRosetta(path.newSubPath("calculationAgent"), processor, CalculationAgent.class, getCalculationAgent());
		processRosetta(path.newSubPath("calculationAgentBusinessCenter"), processor, BusinessCenter.class, getCalculationAgentBusinessCenter());
		processRosetta(path.newSubPath("determiningParty"), processor, PartyReference.class, getDeterminingParty());
		processRosetta(path.newSubPath("barrierDeterminationAgent"), processor, PartyReference.class, getBarrierDeterminationAgent());
		processRosetta(path.newSubPath("hedgingParty"), processor, PartyReference.class, getHedgingParty());
		processRosetta(path.newSubPath("collateral"), processor, Collateral.class, getCollateral());
		processRosetta(path.newSubPath("documentation"), processor, Documentation.class, getDocumentation());
		processRosetta(path.newSubPath("governingLaw"), processor, GoverningLaw.class, getGoverningLaw());
		processRosetta(path.newSubPath("allocations"), processor, Allocations.class, getAllocations());
		processRosetta(path.newSubPath("approvals"), processor, Approvals.class, getApprovals());
	}
	

	/*********************** Builder Interface  ***********************/
	interface TradeBuilder extends Trade, RosettaModelObjectBuilder {
		TradeHeader.TradeHeaderBuilder getOrCreateTradeHeader();
		@Override
		TradeHeader.TradeHeaderBuilder getTradeHeader();
		Product.ProductBuilder getOrCreateProduct();
		@Override
		Product.ProductBuilder getProduct();
		Payment.PaymentBuilder getOrCreateOtherPartyPayment(int index);
		@Override
		List<? extends Payment.PaymentBuilder> getOtherPartyPayment();
		PartyReference.PartyReferenceBuilder getOrCreateBrokerPartyReference(int index);
		@Override
		List<? extends PartyReference.PartyReferenceBuilder> getBrokerPartyReference();
		CalculationAgent.CalculationAgentBuilder getOrCreateCalculationAgent();
		@Override
		CalculationAgent.CalculationAgentBuilder getCalculationAgent();
		BusinessCenter.BusinessCenterBuilder getOrCreateCalculationAgentBusinessCenter();
		@Override
		BusinessCenter.BusinessCenterBuilder getCalculationAgentBusinessCenter();
		PartyReference.PartyReferenceBuilder getOrCreateDeterminingParty(int index);
		@Override
		List<? extends PartyReference.PartyReferenceBuilder> getDeterminingParty();
		PartyReference.PartyReferenceBuilder getOrCreateBarrierDeterminationAgent();
		@Override
		PartyReference.PartyReferenceBuilder getBarrierDeterminationAgent();
		PartyReference.PartyReferenceBuilder getOrCreateHedgingParty(int index);
		@Override
		List<? extends PartyReference.PartyReferenceBuilder> getHedgingParty();
		Collateral.CollateralBuilder getOrCreateCollateral();
		@Override
		Collateral.CollateralBuilder getCollateral();
		Documentation.DocumentationBuilder getOrCreateDocumentation();
		@Override
		Documentation.DocumentationBuilder getDocumentation();
		GoverningLaw.GoverningLawBuilder getOrCreateGoverningLaw();
		@Override
		GoverningLaw.GoverningLawBuilder getGoverningLaw();
		Allocations.AllocationsBuilder getOrCreateAllocations(int index);
		@Override
		List<? extends Allocations.AllocationsBuilder> getAllocations();
		Approvals.ApprovalsBuilder getOrCreateApprovals();
		@Override
		Approvals.ApprovalsBuilder getApprovals();
		Trade.TradeBuilder setId(String id);
		Trade.TradeBuilder setTradeHeader(TradeHeader tradeHeader);
		Trade.TradeBuilder setProduct(Product product);
		Trade.TradeBuilder addOtherPartyPayment(Payment otherPartyPayment);
		Trade.TradeBuilder addOtherPartyPayment(Payment otherPartyPayment, int idx);
		Trade.TradeBuilder addOtherPartyPayment(List<? extends Payment> otherPartyPayment);
		Trade.TradeBuilder setOtherPartyPayment(List<? extends Payment> otherPartyPayment);
		Trade.TradeBuilder addBrokerPartyReference(PartyReference brokerPartyReference);
		Trade.TradeBuilder addBrokerPartyReference(PartyReference brokerPartyReference, int idx);
		Trade.TradeBuilder addBrokerPartyReference(List<? extends PartyReference> brokerPartyReference);
		Trade.TradeBuilder setBrokerPartyReference(List<? extends PartyReference> brokerPartyReference);
		Trade.TradeBuilder setCalculationAgent(CalculationAgent calculationAgent);
		Trade.TradeBuilder setCalculationAgentBusinessCenter(BusinessCenter calculationAgentBusinessCenter);
		Trade.TradeBuilder addDeterminingParty(PartyReference determiningParty);
		Trade.TradeBuilder addDeterminingParty(PartyReference determiningParty, int idx);
		Trade.TradeBuilder addDeterminingParty(List<? extends PartyReference> determiningParty);
		Trade.TradeBuilder setDeterminingParty(List<? extends PartyReference> determiningParty);
		Trade.TradeBuilder setBarrierDeterminationAgent(PartyReference barrierDeterminationAgent);
		Trade.TradeBuilder addHedgingParty(PartyReference hedgingParty);
		Trade.TradeBuilder addHedgingParty(PartyReference hedgingParty, int idx);
		Trade.TradeBuilder addHedgingParty(List<? extends PartyReference> hedgingParty);
		Trade.TradeBuilder setHedgingParty(List<? extends PartyReference> hedgingParty);
		Trade.TradeBuilder setCollateral(Collateral collateral);
		Trade.TradeBuilder setDocumentation(Documentation documentation);
		Trade.TradeBuilder setGoverningLaw(GoverningLaw governingLaw);
		Trade.TradeBuilder addAllocations(Allocations allocations);
		Trade.TradeBuilder addAllocations(Allocations allocations, int idx);
		Trade.TradeBuilder addAllocations(List<? extends Allocations> allocations);
		Trade.TradeBuilder setAllocations(List<? extends Allocations> allocations);
		Trade.TradeBuilder setApprovals(Approvals approvals);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("tradeHeader"), processor, TradeHeader.TradeHeaderBuilder.class, getTradeHeader());
			processRosetta(path.newSubPath("product"), processor, Product.ProductBuilder.class, getProduct());
			processRosetta(path.newSubPath("otherPartyPayment"), processor, Payment.PaymentBuilder.class, getOtherPartyPayment());
			processRosetta(path.newSubPath("brokerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getBrokerPartyReference());
			processRosetta(path.newSubPath("calculationAgent"), processor, CalculationAgent.CalculationAgentBuilder.class, getCalculationAgent());
			processRosetta(path.newSubPath("calculationAgentBusinessCenter"), processor, BusinessCenter.BusinessCenterBuilder.class, getCalculationAgentBusinessCenter());
			processRosetta(path.newSubPath("determiningParty"), processor, PartyReference.PartyReferenceBuilder.class, getDeterminingParty());
			processRosetta(path.newSubPath("barrierDeterminationAgent"), processor, PartyReference.PartyReferenceBuilder.class, getBarrierDeterminationAgent());
			processRosetta(path.newSubPath("hedgingParty"), processor, PartyReference.PartyReferenceBuilder.class, getHedgingParty());
			processRosetta(path.newSubPath("collateral"), processor, Collateral.CollateralBuilder.class, getCollateral());
			processRosetta(path.newSubPath("documentation"), processor, Documentation.DocumentationBuilder.class, getDocumentation());
			processRosetta(path.newSubPath("governingLaw"), processor, GoverningLaw.GoverningLawBuilder.class, getGoverningLaw());
			processRosetta(path.newSubPath("allocations"), processor, Allocations.AllocationsBuilder.class, getAllocations());
			processRosetta(path.newSubPath("approvals"), processor, Approvals.ApprovalsBuilder.class, getApprovals());
		}
		

		Trade.TradeBuilder prune();
	}

	/*********************** Immutable Implementation of Trade  ***********************/
	class TradeImpl implements Trade {
		private final String id;
		private final TradeHeader tradeHeader;
		private final Product product;
		private final List<? extends Payment> otherPartyPayment;
		private final List<? extends PartyReference> brokerPartyReference;
		private final CalculationAgent calculationAgent;
		private final BusinessCenter calculationAgentBusinessCenter;
		private final List<? extends PartyReference> determiningParty;
		private final PartyReference barrierDeterminationAgent;
		private final List<? extends PartyReference> hedgingParty;
		private final Collateral collateral;
		private final Documentation documentation;
		private final GoverningLaw governingLaw;
		private final List<? extends Allocations> allocations;
		private final Approvals approvals;
		
		protected TradeImpl(Trade.TradeBuilder builder) {
			this.id = builder.getId();
			this.tradeHeader = ofNullable(builder.getTradeHeader()).map(f->f.build()).orElse(null);
			this.product = ofNullable(builder.getProduct()).map(f->f.build()).orElse(null);
			this.otherPartyPayment = ofNullable(builder.getOtherPartyPayment()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.brokerPartyReference = ofNullable(builder.getBrokerPartyReference()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.calculationAgent = ofNullable(builder.getCalculationAgent()).map(f->f.build()).orElse(null);
			this.calculationAgentBusinessCenter = ofNullable(builder.getCalculationAgentBusinessCenter()).map(f->f.build()).orElse(null);
			this.determiningParty = ofNullable(builder.getDeterminingParty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.barrierDeterminationAgent = ofNullable(builder.getBarrierDeterminationAgent()).map(f->f.build()).orElse(null);
			this.hedgingParty = ofNullable(builder.getHedgingParty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.collateral = ofNullable(builder.getCollateral()).map(f->f.build()).orElse(null);
			this.documentation = ofNullable(builder.getDocumentation()).map(f->f.build()).orElse(null);
			this.governingLaw = ofNullable(builder.getGoverningLaw()).map(f->f.build()).orElse(null);
			this.allocations = ofNullable(builder.getAllocations()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.approvals = ofNullable(builder.getApprovals()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("tradeHeader")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tradeHeader")
		public TradeHeader getTradeHeader() {
			return tradeHeader;
		}
		
		@Override
		@RosettaAttribute("product")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("product")
		public Product getProduct() {
			return product;
		}
		
		@Override
		@RosettaAttribute("otherPartyPayment")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("otherPartyPayment")
		public List<? extends Payment> getOtherPartyPayment() {
			return otherPartyPayment;
		}
		
		@Override
		@RosettaAttribute("brokerPartyReference")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("brokerPartyReference")
		public List<? extends PartyReference> getBrokerPartyReference() {
			return brokerPartyReference;
		}
		
		@Override
		@RosettaAttribute("calculationAgent")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculationAgent")
		public CalculationAgent getCalculationAgent() {
			return calculationAgent;
		}
		
		@Override
		@RosettaAttribute("calculationAgentBusinessCenter")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculationAgentBusinessCenter")
		public BusinessCenter getCalculationAgentBusinessCenter() {
			return calculationAgentBusinessCenter;
		}
		
		@Override
		@RosettaAttribute("determiningParty")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("determiningParty")
		public List<? extends PartyReference> getDeterminingParty() {
			return determiningParty;
		}
		
		@Override
		@RosettaAttribute("barrierDeterminationAgent")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("barrierDeterminationAgent")
		public PartyReference getBarrierDeterminationAgent() {
			return barrierDeterminationAgent;
		}
		
		@Override
		@RosettaAttribute("hedgingParty")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("hedgingParty")
		public List<? extends PartyReference> getHedgingParty() {
			return hedgingParty;
		}
		
		@Override
		@RosettaAttribute("collateral")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("collateral")
		public Collateral getCollateral() {
			return collateral;
		}
		
		@Override
		@RosettaAttribute("documentation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("documentation")
		public Documentation getDocumentation() {
			return documentation;
		}
		
		@Override
		@RosettaAttribute("governingLaw")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("governingLaw")
		public GoverningLaw getGoverningLaw() {
			return governingLaw;
		}
		
		@Override
		@RosettaAttribute("allocations")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("allocations")
		public List<? extends Allocations> getAllocations() {
			return allocations;
		}
		
		@Override
		@RosettaAttribute("approvals")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("approvals")
		public Approvals getApprovals() {
			return approvals;
		}
		
		@Override
		public Trade build() {
			return this;
		}
		
		@Override
		public Trade.TradeBuilder toBuilder() {
			Trade.TradeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Trade.TradeBuilder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getTradeHeader()).ifPresent(builder::setTradeHeader);
			ofNullable(getProduct()).ifPresent(builder::setProduct);
			ofNullable(getOtherPartyPayment()).ifPresent(builder::setOtherPartyPayment);
			ofNullable(getBrokerPartyReference()).ifPresent(builder::setBrokerPartyReference);
			ofNullable(getCalculationAgent()).ifPresent(builder::setCalculationAgent);
			ofNullable(getCalculationAgentBusinessCenter()).ifPresent(builder::setCalculationAgentBusinessCenter);
			ofNullable(getDeterminingParty()).ifPresent(builder::setDeterminingParty);
			ofNullable(getBarrierDeterminationAgent()).ifPresent(builder::setBarrierDeterminationAgent);
			ofNullable(getHedgingParty()).ifPresent(builder::setHedgingParty);
			ofNullable(getCollateral()).ifPresent(builder::setCollateral);
			ofNullable(getDocumentation()).ifPresent(builder::setDocumentation);
			ofNullable(getGoverningLaw()).ifPresent(builder::setGoverningLaw);
			ofNullable(getAllocations()).ifPresent(builder::setAllocations);
			ofNullable(getApprovals()).ifPresent(builder::setApprovals);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Trade _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(tradeHeader, _that.getTradeHeader())) return false;
			if (!Objects.equals(product, _that.getProduct())) return false;
			if (!ListEquals.listEquals(otherPartyPayment, _that.getOtherPartyPayment())) return false;
			if (!ListEquals.listEquals(brokerPartyReference, _that.getBrokerPartyReference())) return false;
			if (!Objects.equals(calculationAgent, _that.getCalculationAgent())) return false;
			if (!Objects.equals(calculationAgentBusinessCenter, _that.getCalculationAgentBusinessCenter())) return false;
			if (!ListEquals.listEquals(determiningParty, _that.getDeterminingParty())) return false;
			if (!Objects.equals(barrierDeterminationAgent, _that.getBarrierDeterminationAgent())) return false;
			if (!ListEquals.listEquals(hedgingParty, _that.getHedgingParty())) return false;
			if (!Objects.equals(collateral, _that.getCollateral())) return false;
			if (!Objects.equals(documentation, _that.getDocumentation())) return false;
			if (!Objects.equals(governingLaw, _that.getGoverningLaw())) return false;
			if (!ListEquals.listEquals(allocations, _that.getAllocations())) return false;
			if (!Objects.equals(approvals, _that.getApprovals())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (tradeHeader != null ? tradeHeader.hashCode() : 0);
			_result = 31 * _result + (product != null ? product.hashCode() : 0);
			_result = 31 * _result + (otherPartyPayment != null ? otherPartyPayment.hashCode() : 0);
			_result = 31 * _result + (brokerPartyReference != null ? brokerPartyReference.hashCode() : 0);
			_result = 31 * _result + (calculationAgent != null ? calculationAgent.hashCode() : 0);
			_result = 31 * _result + (calculationAgentBusinessCenter != null ? calculationAgentBusinessCenter.hashCode() : 0);
			_result = 31 * _result + (determiningParty != null ? determiningParty.hashCode() : 0);
			_result = 31 * _result + (barrierDeterminationAgent != null ? barrierDeterminationAgent.hashCode() : 0);
			_result = 31 * _result + (hedgingParty != null ? hedgingParty.hashCode() : 0);
			_result = 31 * _result + (collateral != null ? collateral.hashCode() : 0);
			_result = 31 * _result + (documentation != null ? documentation.hashCode() : 0);
			_result = 31 * _result + (governingLaw != null ? governingLaw.hashCode() : 0);
			_result = 31 * _result + (allocations != null ? allocations.hashCode() : 0);
			_result = 31 * _result + (approvals != null ? approvals.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Trade {" +
				"id=" + this.id + ", " +
				"tradeHeader=" + this.tradeHeader + ", " +
				"product=" + this.product + ", " +
				"otherPartyPayment=" + this.otherPartyPayment + ", " +
				"brokerPartyReference=" + this.brokerPartyReference + ", " +
				"calculationAgent=" + this.calculationAgent + ", " +
				"calculationAgentBusinessCenter=" + this.calculationAgentBusinessCenter + ", " +
				"determiningParty=" + this.determiningParty + ", " +
				"barrierDeterminationAgent=" + this.barrierDeterminationAgent + ", " +
				"hedgingParty=" + this.hedgingParty + ", " +
				"collateral=" + this.collateral + ", " +
				"documentation=" + this.documentation + ", " +
				"governingLaw=" + this.governingLaw + ", " +
				"allocations=" + this.allocations + ", " +
				"approvals=" + this.approvals +
			'}';
		}
	}

	/*********************** Builder Implementation of Trade  ***********************/
	class TradeBuilderImpl implements Trade.TradeBuilder {
	
		protected String id;
		protected TradeHeader.TradeHeaderBuilder tradeHeader;
		protected Product.ProductBuilder product;
		protected List<Payment.PaymentBuilder> otherPartyPayment = new ArrayList<>();
		protected List<PartyReference.PartyReferenceBuilder> brokerPartyReference = new ArrayList<>();
		protected CalculationAgent.CalculationAgentBuilder calculationAgent;
		protected BusinessCenter.BusinessCenterBuilder calculationAgentBusinessCenter;
		protected List<PartyReference.PartyReferenceBuilder> determiningParty = new ArrayList<>();
		protected PartyReference.PartyReferenceBuilder barrierDeterminationAgent;
		protected List<PartyReference.PartyReferenceBuilder> hedgingParty = new ArrayList<>();
		protected Collateral.CollateralBuilder collateral;
		protected Documentation.DocumentationBuilder documentation;
		protected GoverningLaw.GoverningLawBuilder governingLaw;
		protected List<Allocations.AllocationsBuilder> allocations = new ArrayList<>();
		protected Approvals.ApprovalsBuilder approvals;
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("tradeHeader")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tradeHeader")
		public TradeHeader.TradeHeaderBuilder getTradeHeader() {
			return tradeHeader;
		}
		
		@Override
		public TradeHeader.TradeHeaderBuilder getOrCreateTradeHeader() {
			TradeHeader.TradeHeaderBuilder result;
			if (tradeHeader!=null) {
				result = tradeHeader;
			}
			else {
				result = tradeHeader = TradeHeader.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("product")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("product")
		public Product.ProductBuilder getProduct() {
			return product;
		}
		
		@Override
		public Product.ProductBuilder getOrCreateProduct() {
			Product.ProductBuilder result;
			if (product!=null) {
				result = product;
			}
			else {
				result = product = Product.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("otherPartyPayment")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("otherPartyPayment")
		public List<? extends Payment.PaymentBuilder> getOtherPartyPayment() {
			return otherPartyPayment;
		}
		
		@Override
		public Payment.PaymentBuilder getOrCreateOtherPartyPayment(int index) {
			if (otherPartyPayment==null) {
				this.otherPartyPayment = new ArrayList<>();
			}
			return getIndex(otherPartyPayment, index, () -> {
						Payment.PaymentBuilder newOtherPartyPayment = Payment.builder();
						return newOtherPartyPayment;
					});
		}
		
		@Override
		@RosettaAttribute("brokerPartyReference")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("brokerPartyReference")
		public List<? extends PartyReference.PartyReferenceBuilder> getBrokerPartyReference() {
			return brokerPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateBrokerPartyReference(int index) {
			if (brokerPartyReference==null) {
				this.brokerPartyReference = new ArrayList<>();
			}
			return getIndex(brokerPartyReference, index, () -> {
						PartyReference.PartyReferenceBuilder newBrokerPartyReference = PartyReference.builder();
						return newBrokerPartyReference;
					});
		}
		
		@Override
		@RosettaAttribute("calculationAgent")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculationAgent")
		public CalculationAgent.CalculationAgentBuilder getCalculationAgent() {
			return calculationAgent;
		}
		
		@Override
		public CalculationAgent.CalculationAgentBuilder getOrCreateCalculationAgent() {
			CalculationAgent.CalculationAgentBuilder result;
			if (calculationAgent!=null) {
				result = calculationAgent;
			}
			else {
				result = calculationAgent = CalculationAgent.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("calculationAgentBusinessCenter")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculationAgentBusinessCenter")
		public BusinessCenter.BusinessCenterBuilder getCalculationAgentBusinessCenter() {
			return calculationAgentBusinessCenter;
		}
		
		@Override
		public BusinessCenter.BusinessCenterBuilder getOrCreateCalculationAgentBusinessCenter() {
			BusinessCenter.BusinessCenterBuilder result;
			if (calculationAgentBusinessCenter!=null) {
				result = calculationAgentBusinessCenter;
			}
			else {
				result = calculationAgentBusinessCenter = BusinessCenter.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("determiningParty")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("determiningParty")
		public List<? extends PartyReference.PartyReferenceBuilder> getDeterminingParty() {
			return determiningParty;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateDeterminingParty(int index) {
			if (determiningParty==null) {
				this.determiningParty = new ArrayList<>();
			}
			return getIndex(determiningParty, index, () -> {
						PartyReference.PartyReferenceBuilder newDeterminingParty = PartyReference.builder();
						return newDeterminingParty;
					});
		}
		
		@Override
		@RosettaAttribute("barrierDeterminationAgent")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("barrierDeterminationAgent")
		public PartyReference.PartyReferenceBuilder getBarrierDeterminationAgent() {
			return barrierDeterminationAgent;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateBarrierDeterminationAgent() {
			PartyReference.PartyReferenceBuilder result;
			if (barrierDeterminationAgent!=null) {
				result = barrierDeterminationAgent;
			}
			else {
				result = barrierDeterminationAgent = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("hedgingParty")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("hedgingParty")
		public List<? extends PartyReference.PartyReferenceBuilder> getHedgingParty() {
			return hedgingParty;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateHedgingParty(int index) {
			if (hedgingParty==null) {
				this.hedgingParty = new ArrayList<>();
			}
			return getIndex(hedgingParty, index, () -> {
						PartyReference.PartyReferenceBuilder newHedgingParty = PartyReference.builder();
						return newHedgingParty;
					});
		}
		
		@Override
		@RosettaAttribute("collateral")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("collateral")
		public Collateral.CollateralBuilder getCollateral() {
			return collateral;
		}
		
		@Override
		public Collateral.CollateralBuilder getOrCreateCollateral() {
			Collateral.CollateralBuilder result;
			if (collateral!=null) {
				result = collateral;
			}
			else {
				result = collateral = Collateral.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("documentation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("documentation")
		public Documentation.DocumentationBuilder getDocumentation() {
			return documentation;
		}
		
		@Override
		public Documentation.DocumentationBuilder getOrCreateDocumentation() {
			Documentation.DocumentationBuilder result;
			if (documentation!=null) {
				result = documentation;
			}
			else {
				result = documentation = Documentation.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("governingLaw")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("governingLaw")
		public GoverningLaw.GoverningLawBuilder getGoverningLaw() {
			return governingLaw;
		}
		
		@Override
		public GoverningLaw.GoverningLawBuilder getOrCreateGoverningLaw() {
			GoverningLaw.GoverningLawBuilder result;
			if (governingLaw!=null) {
				result = governingLaw;
			}
			else {
				result = governingLaw = GoverningLaw.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("allocations")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("allocations")
		public List<? extends Allocations.AllocationsBuilder> getAllocations() {
			return allocations;
		}
		
		@Override
		public Allocations.AllocationsBuilder getOrCreateAllocations(int index) {
			if (allocations==null) {
				this.allocations = new ArrayList<>();
			}
			return getIndex(allocations, index, () -> {
						Allocations.AllocationsBuilder newAllocations = Allocations.builder();
						return newAllocations;
					});
		}
		
		@Override
		@RosettaAttribute("approvals")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("approvals")
		public Approvals.ApprovalsBuilder getApprovals() {
			return approvals;
		}
		
		@Override
		public Approvals.ApprovalsBuilder getOrCreateApprovals() {
			Approvals.ApprovalsBuilder result;
			if (approvals!=null) {
				result = approvals;
			}
			else {
				result = approvals = Approvals.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public Trade.TradeBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("tradeHeader")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("tradeHeader")
		@Override
		public Trade.TradeBuilder setTradeHeader(TradeHeader _tradeHeader) {
			this.tradeHeader = _tradeHeader == null ? null : _tradeHeader.toBuilder();
			return this;
		}
		
		@RosettaAttribute("product")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("product")
		@Override
		public Trade.TradeBuilder setProduct(Product _product) {
			this.product = _product == null ? null : _product.toBuilder();
			return this;
		}
		
		@RosettaAttribute("otherPartyPayment")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("otherPartyPayment")
		@Override
		public Trade.TradeBuilder addOtherPartyPayment(Payment _otherPartyPayment) {
			if (_otherPartyPayment != null) {
				this.otherPartyPayment.add(_otherPartyPayment.toBuilder());
			}
			return this;
		}
		
		@Override
		public Trade.TradeBuilder addOtherPartyPayment(Payment _otherPartyPayment, int idx) {
			getIndex(this.otherPartyPayment, idx, () -> _otherPartyPayment.toBuilder());
			return this;
		}
		
		@Override
		public Trade.TradeBuilder addOtherPartyPayment(List<? extends Payment> otherPartyPayments) {
			if (otherPartyPayments != null) {
				for (final Payment toAdd : otherPartyPayments) {
					this.otherPartyPayment.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("otherPartyPayment")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("otherPartyPayment")
		@Override
		public Trade.TradeBuilder setOtherPartyPayment(List<? extends Payment> otherPartyPayments) {
			if (otherPartyPayments == null) {
				this.otherPartyPayment = new ArrayList<>();
			} else {
				this.otherPartyPayment = otherPartyPayments.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("brokerPartyReference")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("brokerPartyReference")
		@Override
		public Trade.TradeBuilder addBrokerPartyReference(PartyReference _brokerPartyReference) {
			if (_brokerPartyReference != null) {
				this.brokerPartyReference.add(_brokerPartyReference.toBuilder());
			}
			return this;
		}
		
		@Override
		public Trade.TradeBuilder addBrokerPartyReference(PartyReference _brokerPartyReference, int idx) {
			getIndex(this.brokerPartyReference, idx, () -> _brokerPartyReference.toBuilder());
			return this;
		}
		
		@Override
		public Trade.TradeBuilder addBrokerPartyReference(List<? extends PartyReference> brokerPartyReferences) {
			if (brokerPartyReferences != null) {
				for (final PartyReference toAdd : brokerPartyReferences) {
					this.brokerPartyReference.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("brokerPartyReference")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("brokerPartyReference")
		@Override
		public Trade.TradeBuilder setBrokerPartyReference(List<? extends PartyReference> brokerPartyReferences) {
			if (brokerPartyReferences == null) {
				this.brokerPartyReference = new ArrayList<>();
			} else {
				this.brokerPartyReference = brokerPartyReferences.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("calculationAgent")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("calculationAgent")
		@Override
		public Trade.TradeBuilder setCalculationAgent(CalculationAgent _calculationAgent) {
			this.calculationAgent = _calculationAgent == null ? null : _calculationAgent.toBuilder();
			return this;
		}
		
		@RosettaAttribute("calculationAgentBusinessCenter")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("calculationAgentBusinessCenter")
		@Override
		public Trade.TradeBuilder setCalculationAgentBusinessCenter(BusinessCenter _calculationAgentBusinessCenter) {
			this.calculationAgentBusinessCenter = _calculationAgentBusinessCenter == null ? null : _calculationAgentBusinessCenter.toBuilder();
			return this;
		}
		
		@RosettaAttribute("determiningParty")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("determiningParty")
		@Override
		public Trade.TradeBuilder addDeterminingParty(PartyReference _determiningParty) {
			if (_determiningParty != null) {
				this.determiningParty.add(_determiningParty.toBuilder());
			}
			return this;
		}
		
		@Override
		public Trade.TradeBuilder addDeterminingParty(PartyReference _determiningParty, int idx) {
			getIndex(this.determiningParty, idx, () -> _determiningParty.toBuilder());
			return this;
		}
		
		@Override
		public Trade.TradeBuilder addDeterminingParty(List<? extends PartyReference> determiningPartys) {
			if (determiningPartys != null) {
				for (final PartyReference toAdd : determiningPartys) {
					this.determiningParty.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("determiningParty")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("determiningParty")
		@Override
		public Trade.TradeBuilder setDeterminingParty(List<? extends PartyReference> determiningPartys) {
			if (determiningPartys == null) {
				this.determiningParty = new ArrayList<>();
			} else {
				this.determiningParty = determiningPartys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("barrierDeterminationAgent")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("barrierDeterminationAgent")
		@Override
		public Trade.TradeBuilder setBarrierDeterminationAgent(PartyReference _barrierDeterminationAgent) {
			this.barrierDeterminationAgent = _barrierDeterminationAgent == null ? null : _barrierDeterminationAgent.toBuilder();
			return this;
		}
		
		@RosettaAttribute("hedgingParty")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("hedgingParty")
		@Override
		public Trade.TradeBuilder addHedgingParty(PartyReference _hedgingParty) {
			if (_hedgingParty != null) {
				this.hedgingParty.add(_hedgingParty.toBuilder());
			}
			return this;
		}
		
		@Override
		public Trade.TradeBuilder addHedgingParty(PartyReference _hedgingParty, int idx) {
			getIndex(this.hedgingParty, idx, () -> _hedgingParty.toBuilder());
			return this;
		}
		
		@Override
		public Trade.TradeBuilder addHedgingParty(List<? extends PartyReference> hedgingPartys) {
			if (hedgingPartys != null) {
				for (final PartyReference toAdd : hedgingPartys) {
					this.hedgingParty.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("hedgingParty")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("hedgingParty")
		@Override
		public Trade.TradeBuilder setHedgingParty(List<? extends PartyReference> hedgingPartys) {
			if (hedgingPartys == null) {
				this.hedgingParty = new ArrayList<>();
			} else {
				this.hedgingParty = hedgingPartys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("collateral")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("collateral")
		@Override
		public Trade.TradeBuilder setCollateral(Collateral _collateral) {
			this.collateral = _collateral == null ? null : _collateral.toBuilder();
			return this;
		}
		
		@RosettaAttribute("documentation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("documentation")
		@Override
		public Trade.TradeBuilder setDocumentation(Documentation _documentation) {
			this.documentation = _documentation == null ? null : _documentation.toBuilder();
			return this;
		}
		
		@RosettaAttribute("governingLaw")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("governingLaw")
		@Override
		public Trade.TradeBuilder setGoverningLaw(GoverningLaw _governingLaw) {
			this.governingLaw = _governingLaw == null ? null : _governingLaw.toBuilder();
			return this;
		}
		
		@RosettaAttribute("allocations")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("allocations")
		@Override
		public Trade.TradeBuilder addAllocations(Allocations _allocations) {
			if (_allocations != null) {
				this.allocations.add(_allocations.toBuilder());
			}
			return this;
		}
		
		@Override
		public Trade.TradeBuilder addAllocations(Allocations _allocations, int idx) {
			getIndex(this.allocations, idx, () -> _allocations.toBuilder());
			return this;
		}
		
		@Override
		public Trade.TradeBuilder addAllocations(List<? extends Allocations> allocationss) {
			if (allocationss != null) {
				for (final Allocations toAdd : allocationss) {
					this.allocations.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("allocations")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("allocations")
		@Override
		public Trade.TradeBuilder setAllocations(List<? extends Allocations> allocationss) {
			if (allocationss == null) {
				this.allocations = new ArrayList<>();
			} else {
				this.allocations = allocationss.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("approvals")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("approvals")
		@Override
		public Trade.TradeBuilder setApprovals(Approvals _approvals) {
			this.approvals = _approvals == null ? null : _approvals.toBuilder();
			return this;
		}
		
		@Override
		public Trade build() {
			return new Trade.TradeImpl(this);
		}
		
		@Override
		public Trade.TradeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Trade.TradeBuilder prune() {
			if (tradeHeader!=null && !tradeHeader.prune().hasData()) tradeHeader = null;
			if (product!=null && !product.prune().hasData()) product = null;
			otherPartyPayment = otherPartyPayment.stream().filter(b->b!=null).<Payment.PaymentBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			brokerPartyReference = brokerPartyReference.stream().filter(b->b!=null).<PartyReference.PartyReferenceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (calculationAgent!=null && !calculationAgent.prune().hasData()) calculationAgent = null;
			if (calculationAgentBusinessCenter!=null && !calculationAgentBusinessCenter.prune().hasData()) calculationAgentBusinessCenter = null;
			determiningParty = determiningParty.stream().filter(b->b!=null).<PartyReference.PartyReferenceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (barrierDeterminationAgent!=null && !barrierDeterminationAgent.prune().hasData()) barrierDeterminationAgent = null;
			hedgingParty = hedgingParty.stream().filter(b->b!=null).<PartyReference.PartyReferenceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (collateral!=null && !collateral.prune().hasData()) collateral = null;
			if (documentation!=null && !documentation.prune().hasData()) documentation = null;
			if (governingLaw!=null && !governingLaw.prune().hasData()) governingLaw = null;
			allocations = allocations.stream().filter(b->b!=null).<Allocations.AllocationsBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (approvals!=null && !approvals.prune().hasData()) approvals = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			if (getTradeHeader()!=null && getTradeHeader().hasData()) return true;
			if (getProduct()!=null && getProduct().hasData()) return true;
			if (getOtherPartyPayment()!=null && getOtherPartyPayment().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getBrokerPartyReference()!=null && getBrokerPartyReference().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getCalculationAgent()!=null && getCalculationAgent().hasData()) return true;
			if (getCalculationAgentBusinessCenter()!=null && getCalculationAgentBusinessCenter().hasData()) return true;
			if (getDeterminingParty()!=null && getDeterminingParty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getBarrierDeterminationAgent()!=null && getBarrierDeterminationAgent().hasData()) return true;
			if (getHedgingParty()!=null && getHedgingParty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getCollateral()!=null && getCollateral().hasData()) return true;
			if (getDocumentation()!=null && getDocumentation().hasData()) return true;
			if (getGoverningLaw()!=null && getGoverningLaw().hasData()) return true;
			if (getAllocations()!=null && getAllocations().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getApprovals()!=null && getApprovals().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Trade.TradeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Trade.TradeBuilder o = (Trade.TradeBuilder) other;
			
			merger.mergeRosetta(getTradeHeader(), o.getTradeHeader(), this::setTradeHeader);
			merger.mergeRosetta(getProduct(), o.getProduct(), this::setProduct);
			merger.mergeRosetta(getOtherPartyPayment(), o.getOtherPartyPayment(), this::getOrCreateOtherPartyPayment);
			merger.mergeRosetta(getBrokerPartyReference(), o.getBrokerPartyReference(), this::getOrCreateBrokerPartyReference);
			merger.mergeRosetta(getCalculationAgent(), o.getCalculationAgent(), this::setCalculationAgent);
			merger.mergeRosetta(getCalculationAgentBusinessCenter(), o.getCalculationAgentBusinessCenter(), this::setCalculationAgentBusinessCenter);
			merger.mergeRosetta(getDeterminingParty(), o.getDeterminingParty(), this::getOrCreateDeterminingParty);
			merger.mergeRosetta(getBarrierDeterminationAgent(), o.getBarrierDeterminationAgent(), this::setBarrierDeterminationAgent);
			merger.mergeRosetta(getHedgingParty(), o.getHedgingParty(), this::getOrCreateHedgingParty);
			merger.mergeRosetta(getCollateral(), o.getCollateral(), this::setCollateral);
			merger.mergeRosetta(getDocumentation(), o.getDocumentation(), this::setDocumentation);
			merger.mergeRosetta(getGoverningLaw(), o.getGoverningLaw(), this::setGoverningLaw);
			merger.mergeRosetta(getAllocations(), o.getAllocations(), this::getOrCreateAllocations);
			merger.mergeRosetta(getApprovals(), o.getApprovals(), this::setApprovals);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Trade _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(tradeHeader, _that.getTradeHeader())) return false;
			if (!Objects.equals(product, _that.getProduct())) return false;
			if (!ListEquals.listEquals(otherPartyPayment, _that.getOtherPartyPayment())) return false;
			if (!ListEquals.listEquals(brokerPartyReference, _that.getBrokerPartyReference())) return false;
			if (!Objects.equals(calculationAgent, _that.getCalculationAgent())) return false;
			if (!Objects.equals(calculationAgentBusinessCenter, _that.getCalculationAgentBusinessCenter())) return false;
			if (!ListEquals.listEquals(determiningParty, _that.getDeterminingParty())) return false;
			if (!Objects.equals(barrierDeterminationAgent, _that.getBarrierDeterminationAgent())) return false;
			if (!ListEquals.listEquals(hedgingParty, _that.getHedgingParty())) return false;
			if (!Objects.equals(collateral, _that.getCollateral())) return false;
			if (!Objects.equals(documentation, _that.getDocumentation())) return false;
			if (!Objects.equals(governingLaw, _that.getGoverningLaw())) return false;
			if (!ListEquals.listEquals(allocations, _that.getAllocations())) return false;
			if (!Objects.equals(approvals, _that.getApprovals())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (tradeHeader != null ? tradeHeader.hashCode() : 0);
			_result = 31 * _result + (product != null ? product.hashCode() : 0);
			_result = 31 * _result + (otherPartyPayment != null ? otherPartyPayment.hashCode() : 0);
			_result = 31 * _result + (brokerPartyReference != null ? brokerPartyReference.hashCode() : 0);
			_result = 31 * _result + (calculationAgent != null ? calculationAgent.hashCode() : 0);
			_result = 31 * _result + (calculationAgentBusinessCenter != null ? calculationAgentBusinessCenter.hashCode() : 0);
			_result = 31 * _result + (determiningParty != null ? determiningParty.hashCode() : 0);
			_result = 31 * _result + (barrierDeterminationAgent != null ? barrierDeterminationAgent.hashCode() : 0);
			_result = 31 * _result + (hedgingParty != null ? hedgingParty.hashCode() : 0);
			_result = 31 * _result + (collateral != null ? collateral.hashCode() : 0);
			_result = 31 * _result + (documentation != null ? documentation.hashCode() : 0);
			_result = 31 * _result + (governingLaw != null ? governingLaw.hashCode() : 0);
			_result = 31 * _result + (allocations != null ? allocations.hashCode() : 0);
			_result = 31 * _result + (approvals != null ? approvals.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeBuilder {" +
				"id=" + this.id + ", " +
				"tradeHeader=" + this.tradeHeader + ", " +
				"product=" + this.product + ", " +
				"otherPartyPayment=" + this.otherPartyPayment + ", " +
				"brokerPartyReference=" + this.brokerPartyReference + ", " +
				"calculationAgent=" + this.calculationAgent + ", " +
				"calculationAgentBusinessCenter=" + this.calculationAgentBusinessCenter + ", " +
				"determiningParty=" + this.determiningParty + ", " +
				"barrierDeterminationAgent=" + this.barrierDeterminationAgent + ", " +
				"hedgingParty=" + this.hedgingParty + ", " +
				"collateral=" + this.collateral + ", " +
				"documentation=" + this.documentation + ", " +
				"governingLaw=" + this.governingLaw + ", " +
				"allocations=" + this.allocations + ", " +
				"approvals=" + this.approvals +
			'}';
		}
	}
}
