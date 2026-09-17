package fpml.consolidated.eqd;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.consolidated.eq.shared.EquityValuation;
import fpml.consolidated.eq.shared.MakeWholeProvisions;
import fpml.consolidated.eqd.meta.EquityExerciseValuationSettlementMeta;
import fpml.consolidated.fpmlenum.SettlementTypeEnum;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.SettlementPriceDefaultElection;
import fpml.consolidated.shared.SettlementPriceSource;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type for defining exercise procedures for equity options.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type for defining exercise procedures for equity options.
 *
 */
@RosettaDataType(value="EquityExerciseValuationSettlement", builder=EquityExerciseValuationSettlement.EquityExerciseValuationSettlementBuilderImpl.class, version="2.1.1")
@RuneDataType(value="EquityExerciseValuationSettlement", model="fpml", builder=EquityExerciseValuationSettlement.EquityExerciseValuationSettlementBuilderImpl.class, version="2.1.1")
public interface EquityExerciseValuationSettlement extends RosettaModelObject {

	EquityExerciseValuationSettlementMeta metaData = new EquityExerciseValuationSettlementMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The parameters for defining the expiration date and time for a European style equity option.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The parameters for defining the expiration date and time for a European style equity option.
	 *
	 */
	EquityEuropeanExercise getEquityEuropeanExercise();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The parameters for defining the exercise period for an American style equity option together with the rules governing the quantity of the underlying that can be exercised on any given exercise date.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The parameters for defining the exercise period for an American style equity option together with the rules governing the quantity of the underlying that can be exercised on any given exercise date.
	 *
	 */
	EquityAmericanExercise getEquityAmericanExercise();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The parameters for defining the exercise period for an Bermuda style equity option together with the rules governing the quantity of the underlying that can be exercised on any given exercise date.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The parameters for defining the exercise period for an Bermuda style equity option together with the rules governing the quantity of the underlying that can be exercised on any given exercise date.
	 *
	 */
	EquityBermudaExercise getEquityBermudaExercise();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision If true then each option not previously exercised will be deemed to be exercised at the expiration time on the expiration date without service of notice unless the buyer notifies the seller that it no longer wishes this to occur.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision If true then each option not previously exercised will be deemed to be exercised at the expiration time on the expiration date without service of notice unless the buyer notifies the seller that it no longer wishes this to occur.
	 *
	 */
	Boolean getAutomaticExercise();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Provisions covering early exercise of option.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Provisions covering early exercise of option.
	 *
	 */
	MakeWholeProvisions getMakeWholeProvisions();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Prepayment features for Forward.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Prepayment features for Forward.
	 *
	 */
	PrePayment getPrePayment();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The parameters for defining when valuation of the underlying takes place.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The parameters for defining when valuation of the underlying takes place.
	 *
	 */
	EquityValuation getEquityValuation();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The date when the option is to be settled relative to the valuation date. If the settlement date is not specified explicitly then settlement will take place on the valuation date.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The date when the option is to be settled relative to the valuation date. If the settlement date is not specified explicitly then settlement will take place on the valuation date.
	 *
	 */
	AdjustableOrRelativeDate getSettlementDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The currency in which a cash settlement for non-deliverable forward and non-deliverable options.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The currency in which a cash settlement for non-deliverable forward and non-deliverable options.
	 *
	 */
	Currency getSettlementCurrency();
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
	SettlementPriceSource getSettlementPriceSource();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision How the option will be settled.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision How the option will be settled.
	 *
	 */
	SettlementTypeEnum getSettlementType();
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
	AdjustableOrRelativeDate getSettlementMethodElectionDate();
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
	PartyReference getSettlementMethodElectingPartyReference();
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
	SettlementPriceDefaultElection getSettlementPriceDefaultElection();

	/*********************** Build Methods  ***********************/
	EquityExerciseValuationSettlement build();
	
	EquityExerciseValuationSettlement.EquityExerciseValuationSettlementBuilder toBuilder();
	
	static EquityExerciseValuationSettlement.EquityExerciseValuationSettlementBuilder builder() {
		return new EquityExerciseValuationSettlement.EquityExerciseValuationSettlementBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends EquityExerciseValuationSettlement> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends EquityExerciseValuationSettlement> getType() {
		return EquityExerciseValuationSettlement.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("equityEuropeanExercise"), processor, EquityEuropeanExercise.class, getEquityEuropeanExercise());
		processRosetta(path.newSubPath("equityAmericanExercise"), processor, EquityAmericanExercise.class, getEquityAmericanExercise());
		processRosetta(path.newSubPath("equityBermudaExercise"), processor, EquityBermudaExercise.class, getEquityBermudaExercise());
		processor.processBasic(path.newSubPath("automaticExercise"), Boolean.class, getAutomaticExercise(), this);
		processRosetta(path.newSubPath("makeWholeProvisions"), processor, MakeWholeProvisions.class, getMakeWholeProvisions());
		processRosetta(path.newSubPath("prePayment"), processor, PrePayment.class, getPrePayment());
		processRosetta(path.newSubPath("equityValuation"), processor, EquityValuation.class, getEquityValuation());
		processRosetta(path.newSubPath("settlementDate"), processor, AdjustableOrRelativeDate.class, getSettlementDate());
		processRosetta(path.newSubPath("settlementCurrency"), processor, Currency.class, getSettlementCurrency());
		processRosetta(path.newSubPath("settlementPriceSource"), processor, SettlementPriceSource.class, getSettlementPriceSource());
		processor.processBasic(path.newSubPath("settlementType"), SettlementTypeEnum.class, getSettlementType(), this);
		processRosetta(path.newSubPath("settlementMethodElectionDate"), processor, AdjustableOrRelativeDate.class, getSettlementMethodElectionDate());
		processRosetta(path.newSubPath("settlementMethodElectingPartyReference"), processor, PartyReference.class, getSettlementMethodElectingPartyReference());
		processRosetta(path.newSubPath("settlementPriceDefaultElection"), processor, SettlementPriceDefaultElection.class, getSettlementPriceDefaultElection());
	}
	

	/*********************** Builder Interface  ***********************/
	interface EquityExerciseValuationSettlementBuilder extends EquityExerciseValuationSettlement, RosettaModelObjectBuilder {
		EquityEuropeanExercise.EquityEuropeanExerciseBuilder getOrCreateEquityEuropeanExercise();
		@Override
		EquityEuropeanExercise.EquityEuropeanExerciseBuilder getEquityEuropeanExercise();
		EquityAmericanExercise.EquityAmericanExerciseBuilder getOrCreateEquityAmericanExercise();
		@Override
		EquityAmericanExercise.EquityAmericanExerciseBuilder getEquityAmericanExercise();
		EquityBermudaExercise.EquityBermudaExerciseBuilder getOrCreateEquityBermudaExercise();
		@Override
		EquityBermudaExercise.EquityBermudaExerciseBuilder getEquityBermudaExercise();
		MakeWholeProvisions.MakeWholeProvisionsBuilder getOrCreateMakeWholeProvisions();
		@Override
		MakeWholeProvisions.MakeWholeProvisionsBuilder getMakeWholeProvisions();
		PrePayment.PrePaymentBuilder getOrCreatePrePayment();
		@Override
		PrePayment.PrePaymentBuilder getPrePayment();
		EquityValuation.EquityValuationBuilder getOrCreateEquityValuation();
		@Override
		EquityValuation.EquityValuationBuilder getEquityValuation();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateSettlementDate();
		@Override
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getSettlementDate();
		Currency.CurrencyBuilder getOrCreateSettlementCurrency();
		@Override
		Currency.CurrencyBuilder getSettlementCurrency();
		SettlementPriceSource.SettlementPriceSourceBuilder getOrCreateSettlementPriceSource();
		@Override
		SettlementPriceSource.SettlementPriceSourceBuilder getSettlementPriceSource();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateSettlementMethodElectionDate();
		@Override
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getSettlementMethodElectionDate();
		PartyReference.PartyReferenceBuilder getOrCreateSettlementMethodElectingPartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getSettlementMethodElectingPartyReference();
		SettlementPriceDefaultElection.SettlementPriceDefaultElectionBuilder getOrCreateSettlementPriceDefaultElection();
		@Override
		SettlementPriceDefaultElection.SettlementPriceDefaultElectionBuilder getSettlementPriceDefaultElection();
		EquityExerciseValuationSettlement.EquityExerciseValuationSettlementBuilder setEquityEuropeanExercise(EquityEuropeanExercise equityEuropeanExercise);
		EquityExerciseValuationSettlement.EquityExerciseValuationSettlementBuilder setEquityAmericanExercise(EquityAmericanExercise equityAmericanExercise);
		EquityExerciseValuationSettlement.EquityExerciseValuationSettlementBuilder setEquityBermudaExercise(EquityBermudaExercise equityBermudaExercise);
		EquityExerciseValuationSettlement.EquityExerciseValuationSettlementBuilder setAutomaticExercise(Boolean automaticExercise);
		EquityExerciseValuationSettlement.EquityExerciseValuationSettlementBuilder setMakeWholeProvisions(MakeWholeProvisions makeWholeProvisions);
		EquityExerciseValuationSettlement.EquityExerciseValuationSettlementBuilder setPrePayment(PrePayment prePayment);
		EquityExerciseValuationSettlement.EquityExerciseValuationSettlementBuilder setEquityValuation(EquityValuation equityValuation);
		EquityExerciseValuationSettlement.EquityExerciseValuationSettlementBuilder setSettlementDate(AdjustableOrRelativeDate settlementDate);
		EquityExerciseValuationSettlement.EquityExerciseValuationSettlementBuilder setSettlementCurrency(Currency settlementCurrency);
		EquityExerciseValuationSettlement.EquityExerciseValuationSettlementBuilder setSettlementPriceSource(SettlementPriceSource settlementPriceSource);
		EquityExerciseValuationSettlement.EquityExerciseValuationSettlementBuilder setSettlementType(SettlementTypeEnum settlementType);
		EquityExerciseValuationSettlement.EquityExerciseValuationSettlementBuilder setSettlementMethodElectionDate(AdjustableOrRelativeDate settlementMethodElectionDate);
		EquityExerciseValuationSettlement.EquityExerciseValuationSettlementBuilder setSettlementMethodElectingPartyReference(PartyReference settlementMethodElectingPartyReference);
		EquityExerciseValuationSettlement.EquityExerciseValuationSettlementBuilder setSettlementPriceDefaultElection(SettlementPriceDefaultElection settlementPriceDefaultElection);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("equityEuropeanExercise"), processor, EquityEuropeanExercise.EquityEuropeanExerciseBuilder.class, getEquityEuropeanExercise());
			processRosetta(path.newSubPath("equityAmericanExercise"), processor, EquityAmericanExercise.EquityAmericanExerciseBuilder.class, getEquityAmericanExercise());
			processRosetta(path.newSubPath("equityBermudaExercise"), processor, EquityBermudaExercise.EquityBermudaExerciseBuilder.class, getEquityBermudaExercise());
			processor.processBasic(path.newSubPath("automaticExercise"), Boolean.class, getAutomaticExercise(), this);
			processRosetta(path.newSubPath("makeWholeProvisions"), processor, MakeWholeProvisions.MakeWholeProvisionsBuilder.class, getMakeWholeProvisions());
			processRosetta(path.newSubPath("prePayment"), processor, PrePayment.PrePaymentBuilder.class, getPrePayment());
			processRosetta(path.newSubPath("equityValuation"), processor, EquityValuation.EquityValuationBuilder.class, getEquityValuation());
			processRosetta(path.newSubPath("settlementDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getSettlementDate());
			processRosetta(path.newSubPath("settlementCurrency"), processor, Currency.CurrencyBuilder.class, getSettlementCurrency());
			processRosetta(path.newSubPath("settlementPriceSource"), processor, SettlementPriceSource.SettlementPriceSourceBuilder.class, getSettlementPriceSource());
			processor.processBasic(path.newSubPath("settlementType"), SettlementTypeEnum.class, getSettlementType(), this);
			processRosetta(path.newSubPath("settlementMethodElectionDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getSettlementMethodElectionDate());
			processRosetta(path.newSubPath("settlementMethodElectingPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getSettlementMethodElectingPartyReference());
			processRosetta(path.newSubPath("settlementPriceDefaultElection"), processor, SettlementPriceDefaultElection.SettlementPriceDefaultElectionBuilder.class, getSettlementPriceDefaultElection());
		}
		

		EquityExerciseValuationSettlement.EquityExerciseValuationSettlementBuilder prune();
	}

	/*********************** Immutable Implementation of EquityExerciseValuationSettlement  ***********************/
	class EquityExerciseValuationSettlementImpl implements EquityExerciseValuationSettlement {
		private final EquityEuropeanExercise equityEuropeanExercise;
		private final EquityAmericanExercise equityAmericanExercise;
		private final EquityBermudaExercise equityBermudaExercise;
		private final Boolean automaticExercise;
		private final MakeWholeProvisions makeWholeProvisions;
		private final PrePayment prePayment;
		private final EquityValuation equityValuation;
		private final AdjustableOrRelativeDate settlementDate;
		private final Currency settlementCurrency;
		private final SettlementPriceSource settlementPriceSource;
		private final SettlementTypeEnum settlementType;
		private final AdjustableOrRelativeDate settlementMethodElectionDate;
		private final PartyReference settlementMethodElectingPartyReference;
		private final SettlementPriceDefaultElection settlementPriceDefaultElection;
		
		protected EquityExerciseValuationSettlementImpl(EquityExerciseValuationSettlement.EquityExerciseValuationSettlementBuilder builder) {
			this.equityEuropeanExercise = ofNullable(builder.getEquityEuropeanExercise()).map(f->f.build()).orElse(null);
			this.equityAmericanExercise = ofNullable(builder.getEquityAmericanExercise()).map(f->f.build()).orElse(null);
			this.equityBermudaExercise = ofNullable(builder.getEquityBermudaExercise()).map(f->f.build()).orElse(null);
			this.automaticExercise = builder.getAutomaticExercise();
			this.makeWholeProvisions = ofNullable(builder.getMakeWholeProvisions()).map(f->f.build()).orElse(null);
			this.prePayment = ofNullable(builder.getPrePayment()).map(f->f.build()).orElse(null);
			this.equityValuation = ofNullable(builder.getEquityValuation()).map(f->f.build()).orElse(null);
			this.settlementDate = ofNullable(builder.getSettlementDate()).map(f->f.build()).orElse(null);
			this.settlementCurrency = ofNullable(builder.getSettlementCurrency()).map(f->f.build()).orElse(null);
			this.settlementPriceSource = ofNullable(builder.getSettlementPriceSource()).map(f->f.build()).orElse(null);
			this.settlementType = builder.getSettlementType();
			this.settlementMethodElectionDate = ofNullable(builder.getSettlementMethodElectionDate()).map(f->f.build()).orElse(null);
			this.settlementMethodElectingPartyReference = ofNullable(builder.getSettlementMethodElectingPartyReference()).map(f->f.build()).orElse(null);
			this.settlementPriceDefaultElection = ofNullable(builder.getSettlementPriceDefaultElection()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("equityEuropeanExercise")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("equityEuropeanExercise")
		public EquityEuropeanExercise getEquityEuropeanExercise() {
			return equityEuropeanExercise;
		}
		
		@Override
		@RosettaAttribute("equityAmericanExercise")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("equityAmericanExercise")
		public EquityAmericanExercise getEquityAmericanExercise() {
			return equityAmericanExercise;
		}
		
		@Override
		@RosettaAttribute("equityBermudaExercise")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("equityBermudaExercise")
		public EquityBermudaExercise getEquityBermudaExercise() {
			return equityBermudaExercise;
		}
		
		@Override
		@RosettaAttribute("automaticExercise")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("automaticExercise")
		public Boolean getAutomaticExercise() {
			return automaticExercise;
		}
		
		@Override
		@RosettaAttribute("makeWholeProvisions")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("makeWholeProvisions")
		public MakeWholeProvisions getMakeWholeProvisions() {
			return makeWholeProvisions;
		}
		
		@Override
		@RosettaAttribute("prePayment")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("prePayment")
		public PrePayment getPrePayment() {
			return prePayment;
		}
		
		@Override
		@RosettaAttribute("equityValuation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("equityValuation")
		public EquityValuation getEquityValuation() {
			return equityValuation;
		}
		
		@Override
		@RosettaAttribute("settlementDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementDate")
		public AdjustableOrRelativeDate getSettlementDate() {
			return settlementDate;
		}
		
		@Override
		@RosettaAttribute("settlementCurrency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementCurrency")
		public Currency getSettlementCurrency() {
			return settlementCurrency;
		}
		
		@Override
		@RosettaAttribute("settlementPriceSource")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementPriceSource")
		public SettlementPriceSource getSettlementPriceSource() {
			return settlementPriceSource;
		}
		
		@Override
		@RosettaAttribute("settlementType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementType")
		public SettlementTypeEnum getSettlementType() {
			return settlementType;
		}
		
		@Override
		@RosettaAttribute("settlementMethodElectionDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementMethodElectionDate")
		public AdjustableOrRelativeDate getSettlementMethodElectionDate() {
			return settlementMethodElectionDate;
		}
		
		@Override
		@RosettaAttribute("settlementMethodElectingPartyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementMethodElectingPartyReference")
		public PartyReference getSettlementMethodElectingPartyReference() {
			return settlementMethodElectingPartyReference;
		}
		
		@Override
		@RosettaAttribute("settlementPriceDefaultElection")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementPriceDefaultElection")
		public SettlementPriceDefaultElection getSettlementPriceDefaultElection() {
			return settlementPriceDefaultElection;
		}
		
		@Override
		public EquityExerciseValuationSettlement build() {
			return this;
		}
		
		@Override
		public EquityExerciseValuationSettlement.EquityExerciseValuationSettlementBuilder toBuilder() {
			EquityExerciseValuationSettlement.EquityExerciseValuationSettlementBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EquityExerciseValuationSettlement.EquityExerciseValuationSettlementBuilder builder) {
			ofNullable(getEquityEuropeanExercise()).ifPresent(builder::setEquityEuropeanExercise);
			ofNullable(getEquityAmericanExercise()).ifPresent(builder::setEquityAmericanExercise);
			ofNullable(getEquityBermudaExercise()).ifPresent(builder::setEquityBermudaExercise);
			ofNullable(getAutomaticExercise()).ifPresent(builder::setAutomaticExercise);
			ofNullable(getMakeWholeProvisions()).ifPresent(builder::setMakeWholeProvisions);
			ofNullable(getPrePayment()).ifPresent(builder::setPrePayment);
			ofNullable(getEquityValuation()).ifPresent(builder::setEquityValuation);
			ofNullable(getSettlementDate()).ifPresent(builder::setSettlementDate);
			ofNullable(getSettlementCurrency()).ifPresent(builder::setSettlementCurrency);
			ofNullable(getSettlementPriceSource()).ifPresent(builder::setSettlementPriceSource);
			ofNullable(getSettlementType()).ifPresent(builder::setSettlementType);
			ofNullable(getSettlementMethodElectionDate()).ifPresent(builder::setSettlementMethodElectionDate);
			ofNullable(getSettlementMethodElectingPartyReference()).ifPresent(builder::setSettlementMethodElectingPartyReference);
			ofNullable(getSettlementPriceDefaultElection()).ifPresent(builder::setSettlementPriceDefaultElection);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EquityExerciseValuationSettlement _that = getType().cast(o);
		
			if (!Objects.equals(equityEuropeanExercise, _that.getEquityEuropeanExercise())) return false;
			if (!Objects.equals(equityAmericanExercise, _that.getEquityAmericanExercise())) return false;
			if (!Objects.equals(equityBermudaExercise, _that.getEquityBermudaExercise())) return false;
			if (!Objects.equals(automaticExercise, _that.getAutomaticExercise())) return false;
			if (!Objects.equals(makeWholeProvisions, _that.getMakeWholeProvisions())) return false;
			if (!Objects.equals(prePayment, _that.getPrePayment())) return false;
			if (!Objects.equals(equityValuation, _that.getEquityValuation())) return false;
			if (!Objects.equals(settlementDate, _that.getSettlementDate())) return false;
			if (!Objects.equals(settlementCurrency, _that.getSettlementCurrency())) return false;
			if (!Objects.equals(settlementPriceSource, _that.getSettlementPriceSource())) return false;
			if (!Objects.equals(settlementType, _that.getSettlementType())) return false;
			if (!Objects.equals(settlementMethodElectionDate, _that.getSettlementMethodElectionDate())) return false;
			if (!Objects.equals(settlementMethodElectingPartyReference, _that.getSettlementMethodElectingPartyReference())) return false;
			if (!Objects.equals(settlementPriceDefaultElection, _that.getSettlementPriceDefaultElection())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (equityEuropeanExercise != null ? equityEuropeanExercise.hashCode() : 0);
			_result = 31 * _result + (equityAmericanExercise != null ? equityAmericanExercise.hashCode() : 0);
			_result = 31 * _result + (equityBermudaExercise != null ? equityBermudaExercise.hashCode() : 0);
			_result = 31 * _result + (automaticExercise != null ? automaticExercise.hashCode() : 0);
			_result = 31 * _result + (makeWholeProvisions != null ? makeWholeProvisions.hashCode() : 0);
			_result = 31 * _result + (prePayment != null ? prePayment.hashCode() : 0);
			_result = 31 * _result + (equityValuation != null ? equityValuation.hashCode() : 0);
			_result = 31 * _result + (settlementDate != null ? settlementDate.hashCode() : 0);
			_result = 31 * _result + (settlementCurrency != null ? settlementCurrency.hashCode() : 0);
			_result = 31 * _result + (settlementPriceSource != null ? settlementPriceSource.hashCode() : 0);
			_result = 31 * _result + (settlementType != null ? settlementType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (settlementMethodElectionDate != null ? settlementMethodElectionDate.hashCode() : 0);
			_result = 31 * _result + (settlementMethodElectingPartyReference != null ? settlementMethodElectingPartyReference.hashCode() : 0);
			_result = 31 * _result + (settlementPriceDefaultElection != null ? settlementPriceDefaultElection.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EquityExerciseValuationSettlement {" +
				"equityEuropeanExercise=" + this.equityEuropeanExercise + ", " +
				"equityAmericanExercise=" + this.equityAmericanExercise + ", " +
				"equityBermudaExercise=" + this.equityBermudaExercise + ", " +
				"automaticExercise=" + this.automaticExercise + ", " +
				"makeWholeProvisions=" + this.makeWholeProvisions + ", " +
				"prePayment=" + this.prePayment + ", " +
				"equityValuation=" + this.equityValuation + ", " +
				"settlementDate=" + this.settlementDate + ", " +
				"settlementCurrency=" + this.settlementCurrency + ", " +
				"settlementPriceSource=" + this.settlementPriceSource + ", " +
				"settlementType=" + this.settlementType + ", " +
				"settlementMethodElectionDate=" + this.settlementMethodElectionDate + ", " +
				"settlementMethodElectingPartyReference=" + this.settlementMethodElectingPartyReference + ", " +
				"settlementPriceDefaultElection=" + this.settlementPriceDefaultElection +
			'}';
		}
	}

	/*********************** Builder Implementation of EquityExerciseValuationSettlement  ***********************/
	class EquityExerciseValuationSettlementBuilderImpl implements EquityExerciseValuationSettlement.EquityExerciseValuationSettlementBuilder {
	
		protected EquityEuropeanExercise.EquityEuropeanExerciseBuilder equityEuropeanExercise;
		protected EquityAmericanExercise.EquityAmericanExerciseBuilder equityAmericanExercise;
		protected EquityBermudaExercise.EquityBermudaExerciseBuilder equityBermudaExercise;
		protected Boolean automaticExercise;
		protected MakeWholeProvisions.MakeWholeProvisionsBuilder makeWholeProvisions;
		protected PrePayment.PrePaymentBuilder prePayment;
		protected EquityValuation.EquityValuationBuilder equityValuation;
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder settlementDate;
		protected Currency.CurrencyBuilder settlementCurrency;
		protected SettlementPriceSource.SettlementPriceSourceBuilder settlementPriceSource;
		protected SettlementTypeEnum settlementType;
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder settlementMethodElectionDate;
		protected PartyReference.PartyReferenceBuilder settlementMethodElectingPartyReference;
		protected SettlementPriceDefaultElection.SettlementPriceDefaultElectionBuilder settlementPriceDefaultElection;
		
		@Override
		@RosettaAttribute("equityEuropeanExercise")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("equityEuropeanExercise")
		public EquityEuropeanExercise.EquityEuropeanExerciseBuilder getEquityEuropeanExercise() {
			return equityEuropeanExercise;
		}
		
		@Override
		public EquityEuropeanExercise.EquityEuropeanExerciseBuilder getOrCreateEquityEuropeanExercise() {
			EquityEuropeanExercise.EquityEuropeanExerciseBuilder result;
			if (equityEuropeanExercise!=null) {
				result = equityEuropeanExercise;
			}
			else {
				result = equityEuropeanExercise = EquityEuropeanExercise.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("equityAmericanExercise")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("equityAmericanExercise")
		public EquityAmericanExercise.EquityAmericanExerciseBuilder getEquityAmericanExercise() {
			return equityAmericanExercise;
		}
		
		@Override
		public EquityAmericanExercise.EquityAmericanExerciseBuilder getOrCreateEquityAmericanExercise() {
			EquityAmericanExercise.EquityAmericanExerciseBuilder result;
			if (equityAmericanExercise!=null) {
				result = equityAmericanExercise;
			}
			else {
				result = equityAmericanExercise = EquityAmericanExercise.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("equityBermudaExercise")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("equityBermudaExercise")
		public EquityBermudaExercise.EquityBermudaExerciseBuilder getEquityBermudaExercise() {
			return equityBermudaExercise;
		}
		
		@Override
		public EquityBermudaExercise.EquityBermudaExerciseBuilder getOrCreateEquityBermudaExercise() {
			EquityBermudaExercise.EquityBermudaExerciseBuilder result;
			if (equityBermudaExercise!=null) {
				result = equityBermudaExercise;
			}
			else {
				result = equityBermudaExercise = EquityBermudaExercise.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("automaticExercise")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("automaticExercise")
		public Boolean getAutomaticExercise() {
			return automaticExercise;
		}
		
		@Override
		@RosettaAttribute("makeWholeProvisions")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("makeWholeProvisions")
		public MakeWholeProvisions.MakeWholeProvisionsBuilder getMakeWholeProvisions() {
			return makeWholeProvisions;
		}
		
		@Override
		public MakeWholeProvisions.MakeWholeProvisionsBuilder getOrCreateMakeWholeProvisions() {
			MakeWholeProvisions.MakeWholeProvisionsBuilder result;
			if (makeWholeProvisions!=null) {
				result = makeWholeProvisions;
			}
			else {
				result = makeWholeProvisions = MakeWholeProvisions.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("prePayment")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("prePayment")
		public PrePayment.PrePaymentBuilder getPrePayment() {
			return prePayment;
		}
		
		@Override
		public PrePayment.PrePaymentBuilder getOrCreatePrePayment() {
			PrePayment.PrePaymentBuilder result;
			if (prePayment!=null) {
				result = prePayment;
			}
			else {
				result = prePayment = PrePayment.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("equityValuation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("equityValuation")
		public EquityValuation.EquityValuationBuilder getEquityValuation() {
			return equityValuation;
		}
		
		@Override
		public EquityValuation.EquityValuationBuilder getOrCreateEquityValuation() {
			EquityValuation.EquityValuationBuilder result;
			if (equityValuation!=null) {
				result = equityValuation;
			}
			else {
				result = equityValuation = EquityValuation.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("settlementDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementDate")
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getSettlementDate() {
			return settlementDate;
		}
		
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateSettlementDate() {
			AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder result;
			if (settlementDate!=null) {
				result = settlementDate;
			}
			else {
				result = settlementDate = AdjustableOrRelativeDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("settlementCurrency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementCurrency")
		public Currency.CurrencyBuilder getSettlementCurrency() {
			return settlementCurrency;
		}
		
		@Override
		public Currency.CurrencyBuilder getOrCreateSettlementCurrency() {
			Currency.CurrencyBuilder result;
			if (settlementCurrency!=null) {
				result = settlementCurrency;
			}
			else {
				result = settlementCurrency = Currency.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("settlementPriceSource")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementPriceSource")
		public SettlementPriceSource.SettlementPriceSourceBuilder getSettlementPriceSource() {
			return settlementPriceSource;
		}
		
		@Override
		public SettlementPriceSource.SettlementPriceSourceBuilder getOrCreateSettlementPriceSource() {
			SettlementPriceSource.SettlementPriceSourceBuilder result;
			if (settlementPriceSource!=null) {
				result = settlementPriceSource;
			}
			else {
				result = settlementPriceSource = SettlementPriceSource.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("settlementType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementType")
		public SettlementTypeEnum getSettlementType() {
			return settlementType;
		}
		
		@Override
		@RosettaAttribute("settlementMethodElectionDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementMethodElectionDate")
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getSettlementMethodElectionDate() {
			return settlementMethodElectionDate;
		}
		
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateSettlementMethodElectionDate() {
			AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder result;
			if (settlementMethodElectionDate!=null) {
				result = settlementMethodElectionDate;
			}
			else {
				result = settlementMethodElectionDate = AdjustableOrRelativeDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("settlementMethodElectingPartyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementMethodElectingPartyReference")
		public PartyReference.PartyReferenceBuilder getSettlementMethodElectingPartyReference() {
			return settlementMethodElectingPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateSettlementMethodElectingPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (settlementMethodElectingPartyReference!=null) {
				result = settlementMethodElectingPartyReference;
			}
			else {
				result = settlementMethodElectingPartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("settlementPriceDefaultElection")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementPriceDefaultElection")
		public SettlementPriceDefaultElection.SettlementPriceDefaultElectionBuilder getSettlementPriceDefaultElection() {
			return settlementPriceDefaultElection;
		}
		
		@Override
		public SettlementPriceDefaultElection.SettlementPriceDefaultElectionBuilder getOrCreateSettlementPriceDefaultElection() {
			SettlementPriceDefaultElection.SettlementPriceDefaultElectionBuilder result;
			if (settlementPriceDefaultElection!=null) {
				result = settlementPriceDefaultElection;
			}
			else {
				result = settlementPriceDefaultElection = SettlementPriceDefaultElection.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("equityEuropeanExercise")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("equityEuropeanExercise")
		@Override
		public EquityExerciseValuationSettlement.EquityExerciseValuationSettlementBuilder setEquityEuropeanExercise(EquityEuropeanExercise _equityEuropeanExercise) {
			this.equityEuropeanExercise = _equityEuropeanExercise == null ? null : _equityEuropeanExercise.toBuilder();
			return this;
		}
		
		@RosettaAttribute("equityAmericanExercise")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("equityAmericanExercise")
		@Override
		public EquityExerciseValuationSettlement.EquityExerciseValuationSettlementBuilder setEquityAmericanExercise(EquityAmericanExercise _equityAmericanExercise) {
			this.equityAmericanExercise = _equityAmericanExercise == null ? null : _equityAmericanExercise.toBuilder();
			return this;
		}
		
		@RosettaAttribute("equityBermudaExercise")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("equityBermudaExercise")
		@Override
		public EquityExerciseValuationSettlement.EquityExerciseValuationSettlementBuilder setEquityBermudaExercise(EquityBermudaExercise _equityBermudaExercise) {
			this.equityBermudaExercise = _equityBermudaExercise == null ? null : _equityBermudaExercise.toBuilder();
			return this;
		}
		
		@RosettaAttribute("automaticExercise")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("automaticExercise")
		@Override
		public EquityExerciseValuationSettlement.EquityExerciseValuationSettlementBuilder setAutomaticExercise(Boolean _automaticExercise) {
			this.automaticExercise = _automaticExercise == null ? null : _automaticExercise;
			return this;
		}
		
		@RosettaAttribute("makeWholeProvisions")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("makeWholeProvisions")
		@Override
		public EquityExerciseValuationSettlement.EquityExerciseValuationSettlementBuilder setMakeWholeProvisions(MakeWholeProvisions _makeWholeProvisions) {
			this.makeWholeProvisions = _makeWholeProvisions == null ? null : _makeWholeProvisions.toBuilder();
			return this;
		}
		
		@RosettaAttribute("prePayment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("prePayment")
		@Override
		public EquityExerciseValuationSettlement.EquityExerciseValuationSettlementBuilder setPrePayment(PrePayment _prePayment) {
			this.prePayment = _prePayment == null ? null : _prePayment.toBuilder();
			return this;
		}
		
		@RosettaAttribute("equityValuation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("equityValuation")
		@Override
		public EquityExerciseValuationSettlement.EquityExerciseValuationSettlementBuilder setEquityValuation(EquityValuation _equityValuation) {
			this.equityValuation = _equityValuation == null ? null : _equityValuation.toBuilder();
			return this;
		}
		
		@RosettaAttribute("settlementDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementDate")
		@Override
		public EquityExerciseValuationSettlement.EquityExerciseValuationSettlementBuilder setSettlementDate(AdjustableOrRelativeDate _settlementDate) {
			this.settlementDate = _settlementDate == null ? null : _settlementDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("settlementCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementCurrency")
		@Override
		public EquityExerciseValuationSettlement.EquityExerciseValuationSettlementBuilder setSettlementCurrency(Currency _settlementCurrency) {
			this.settlementCurrency = _settlementCurrency == null ? null : _settlementCurrency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("settlementPriceSource")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementPriceSource")
		@Override
		public EquityExerciseValuationSettlement.EquityExerciseValuationSettlementBuilder setSettlementPriceSource(SettlementPriceSource _settlementPriceSource) {
			this.settlementPriceSource = _settlementPriceSource == null ? null : _settlementPriceSource.toBuilder();
			return this;
		}
		
		@RosettaAttribute("settlementType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementType")
		@Override
		public EquityExerciseValuationSettlement.EquityExerciseValuationSettlementBuilder setSettlementType(SettlementTypeEnum _settlementType) {
			this.settlementType = _settlementType == null ? null : _settlementType;
			return this;
		}
		
		@RosettaAttribute("settlementMethodElectionDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementMethodElectionDate")
		@Override
		public EquityExerciseValuationSettlement.EquityExerciseValuationSettlementBuilder setSettlementMethodElectionDate(AdjustableOrRelativeDate _settlementMethodElectionDate) {
			this.settlementMethodElectionDate = _settlementMethodElectionDate == null ? null : _settlementMethodElectionDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("settlementMethodElectingPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementMethodElectingPartyReference")
		@Override
		public EquityExerciseValuationSettlement.EquityExerciseValuationSettlementBuilder setSettlementMethodElectingPartyReference(PartyReference _settlementMethodElectingPartyReference) {
			this.settlementMethodElectingPartyReference = _settlementMethodElectingPartyReference == null ? null : _settlementMethodElectingPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("settlementPriceDefaultElection")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementPriceDefaultElection")
		@Override
		public EquityExerciseValuationSettlement.EquityExerciseValuationSettlementBuilder setSettlementPriceDefaultElection(SettlementPriceDefaultElection _settlementPriceDefaultElection) {
			this.settlementPriceDefaultElection = _settlementPriceDefaultElection == null ? null : _settlementPriceDefaultElection.toBuilder();
			return this;
		}
		
		@Override
		public EquityExerciseValuationSettlement build() {
			return new EquityExerciseValuationSettlement.EquityExerciseValuationSettlementImpl(this);
		}
		
		@Override
		public EquityExerciseValuationSettlement.EquityExerciseValuationSettlementBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EquityExerciseValuationSettlement.EquityExerciseValuationSettlementBuilder prune() {
			if (equityEuropeanExercise!=null && !equityEuropeanExercise.prune().hasData()) equityEuropeanExercise = null;
			if (equityAmericanExercise!=null && !equityAmericanExercise.prune().hasData()) equityAmericanExercise = null;
			if (equityBermudaExercise!=null && !equityBermudaExercise.prune().hasData()) equityBermudaExercise = null;
			if (makeWholeProvisions!=null && !makeWholeProvisions.prune().hasData()) makeWholeProvisions = null;
			if (prePayment!=null && !prePayment.prune().hasData()) prePayment = null;
			if (equityValuation!=null && !equityValuation.prune().hasData()) equityValuation = null;
			if (settlementDate!=null && !settlementDate.prune().hasData()) settlementDate = null;
			if (settlementCurrency!=null && !settlementCurrency.prune().hasData()) settlementCurrency = null;
			if (settlementPriceSource!=null && !settlementPriceSource.prune().hasData()) settlementPriceSource = null;
			if (settlementMethodElectionDate!=null && !settlementMethodElectionDate.prune().hasData()) settlementMethodElectionDate = null;
			if (settlementMethodElectingPartyReference!=null && !settlementMethodElectingPartyReference.prune().hasData()) settlementMethodElectingPartyReference = null;
			if (settlementPriceDefaultElection!=null && !settlementPriceDefaultElection.prune().hasData()) settlementPriceDefaultElection = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getEquityEuropeanExercise()!=null && getEquityEuropeanExercise().hasData()) return true;
			if (getEquityAmericanExercise()!=null && getEquityAmericanExercise().hasData()) return true;
			if (getEquityBermudaExercise()!=null && getEquityBermudaExercise().hasData()) return true;
			if (getAutomaticExercise()!=null) return true;
			if (getMakeWholeProvisions()!=null && getMakeWholeProvisions().hasData()) return true;
			if (getPrePayment()!=null && getPrePayment().hasData()) return true;
			if (getEquityValuation()!=null && getEquityValuation().hasData()) return true;
			if (getSettlementDate()!=null && getSettlementDate().hasData()) return true;
			if (getSettlementCurrency()!=null && getSettlementCurrency().hasData()) return true;
			if (getSettlementPriceSource()!=null && getSettlementPriceSource().hasData()) return true;
			if (getSettlementType()!=null) return true;
			if (getSettlementMethodElectionDate()!=null && getSettlementMethodElectionDate().hasData()) return true;
			if (getSettlementMethodElectingPartyReference()!=null && getSettlementMethodElectingPartyReference().hasData()) return true;
			if (getSettlementPriceDefaultElection()!=null && getSettlementPriceDefaultElection().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EquityExerciseValuationSettlement.EquityExerciseValuationSettlementBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			EquityExerciseValuationSettlement.EquityExerciseValuationSettlementBuilder o = (EquityExerciseValuationSettlement.EquityExerciseValuationSettlementBuilder) other;
			
			merger.mergeRosetta(getEquityEuropeanExercise(), o.getEquityEuropeanExercise(), this::setEquityEuropeanExercise);
			merger.mergeRosetta(getEquityAmericanExercise(), o.getEquityAmericanExercise(), this::setEquityAmericanExercise);
			merger.mergeRosetta(getEquityBermudaExercise(), o.getEquityBermudaExercise(), this::setEquityBermudaExercise);
			merger.mergeRosetta(getMakeWholeProvisions(), o.getMakeWholeProvisions(), this::setMakeWholeProvisions);
			merger.mergeRosetta(getPrePayment(), o.getPrePayment(), this::setPrePayment);
			merger.mergeRosetta(getEquityValuation(), o.getEquityValuation(), this::setEquityValuation);
			merger.mergeRosetta(getSettlementDate(), o.getSettlementDate(), this::setSettlementDate);
			merger.mergeRosetta(getSettlementCurrency(), o.getSettlementCurrency(), this::setSettlementCurrency);
			merger.mergeRosetta(getSettlementPriceSource(), o.getSettlementPriceSource(), this::setSettlementPriceSource);
			merger.mergeRosetta(getSettlementMethodElectionDate(), o.getSettlementMethodElectionDate(), this::setSettlementMethodElectionDate);
			merger.mergeRosetta(getSettlementMethodElectingPartyReference(), o.getSettlementMethodElectingPartyReference(), this::setSettlementMethodElectingPartyReference);
			merger.mergeRosetta(getSettlementPriceDefaultElection(), o.getSettlementPriceDefaultElection(), this::setSettlementPriceDefaultElection);
			
			merger.mergeBasic(getAutomaticExercise(), o.getAutomaticExercise(), this::setAutomaticExercise);
			merger.mergeBasic(getSettlementType(), o.getSettlementType(), this::setSettlementType);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EquityExerciseValuationSettlement _that = getType().cast(o);
		
			if (!Objects.equals(equityEuropeanExercise, _that.getEquityEuropeanExercise())) return false;
			if (!Objects.equals(equityAmericanExercise, _that.getEquityAmericanExercise())) return false;
			if (!Objects.equals(equityBermudaExercise, _that.getEquityBermudaExercise())) return false;
			if (!Objects.equals(automaticExercise, _that.getAutomaticExercise())) return false;
			if (!Objects.equals(makeWholeProvisions, _that.getMakeWholeProvisions())) return false;
			if (!Objects.equals(prePayment, _that.getPrePayment())) return false;
			if (!Objects.equals(equityValuation, _that.getEquityValuation())) return false;
			if (!Objects.equals(settlementDate, _that.getSettlementDate())) return false;
			if (!Objects.equals(settlementCurrency, _that.getSettlementCurrency())) return false;
			if (!Objects.equals(settlementPriceSource, _that.getSettlementPriceSource())) return false;
			if (!Objects.equals(settlementType, _that.getSettlementType())) return false;
			if (!Objects.equals(settlementMethodElectionDate, _that.getSettlementMethodElectionDate())) return false;
			if (!Objects.equals(settlementMethodElectingPartyReference, _that.getSettlementMethodElectingPartyReference())) return false;
			if (!Objects.equals(settlementPriceDefaultElection, _that.getSettlementPriceDefaultElection())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (equityEuropeanExercise != null ? equityEuropeanExercise.hashCode() : 0);
			_result = 31 * _result + (equityAmericanExercise != null ? equityAmericanExercise.hashCode() : 0);
			_result = 31 * _result + (equityBermudaExercise != null ? equityBermudaExercise.hashCode() : 0);
			_result = 31 * _result + (automaticExercise != null ? automaticExercise.hashCode() : 0);
			_result = 31 * _result + (makeWholeProvisions != null ? makeWholeProvisions.hashCode() : 0);
			_result = 31 * _result + (prePayment != null ? prePayment.hashCode() : 0);
			_result = 31 * _result + (equityValuation != null ? equityValuation.hashCode() : 0);
			_result = 31 * _result + (settlementDate != null ? settlementDate.hashCode() : 0);
			_result = 31 * _result + (settlementCurrency != null ? settlementCurrency.hashCode() : 0);
			_result = 31 * _result + (settlementPriceSource != null ? settlementPriceSource.hashCode() : 0);
			_result = 31 * _result + (settlementType != null ? settlementType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (settlementMethodElectionDate != null ? settlementMethodElectionDate.hashCode() : 0);
			_result = 31 * _result + (settlementMethodElectingPartyReference != null ? settlementMethodElectingPartyReference.hashCode() : 0);
			_result = 31 * _result + (settlementPriceDefaultElection != null ? settlementPriceDefaultElection.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EquityExerciseValuationSettlementBuilder {" +
				"equityEuropeanExercise=" + this.equityEuropeanExercise + ", " +
				"equityAmericanExercise=" + this.equityAmericanExercise + ", " +
				"equityBermudaExercise=" + this.equityBermudaExercise + ", " +
				"automaticExercise=" + this.automaticExercise + ", " +
				"makeWholeProvisions=" + this.makeWholeProvisions + ", " +
				"prePayment=" + this.prePayment + ", " +
				"equityValuation=" + this.equityValuation + ", " +
				"settlementDate=" + this.settlementDate + ", " +
				"settlementCurrency=" + this.settlementCurrency + ", " +
				"settlementPriceSource=" + this.settlementPriceSource + ", " +
				"settlementType=" + this.settlementType + ", " +
				"settlementMethodElectionDate=" + this.settlementMethodElectionDate + ", " +
				"settlementMethodElectingPartyReference=" + this.settlementMethodElectingPartyReference + ", " +
				"settlementPriceDefaultElection=" + this.settlementPriceDefaultElection +
			'}';
		}
	}
}
