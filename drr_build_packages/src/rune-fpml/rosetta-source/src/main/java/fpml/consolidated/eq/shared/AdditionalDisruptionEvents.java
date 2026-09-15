package fpml.consolidated.eq.shared;

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
import fpml.consolidated.eq.shared.meta.AdditionalDisruptionEventsMeta;
import fpml.consolidated.shared.PartyReference;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type for defining ISDA 2002 Equity Derivative Additional Disruption Events.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type for defining ISDA 2002 Equity Derivative Additional Disruption Events.
 *
 */
@RosettaDataType(value="AdditionalDisruptionEvents", builder=AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilderImpl.class, version="2.1.1")
@RuneDataType(value="AdditionalDisruptionEvents", model="fpml", builder=AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilderImpl.class, version="2.1.1")
public interface AdditionalDisruptionEvents extends RosettaModelObject {

	AdditionalDisruptionEventsMeta metaData = new AdditionalDisruptionEventsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision If true, then change in law is applicable.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision If true, then change in law is applicable.
	 *
	 */
	Boolean getChangeInLaw();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Where the underlying is shares and the transaction is physically settled, then, if true, a failure to deliver the shares on the settlement date will not be an event of default for the purposes of the master agreement.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Where the underlying is shares and the transaction is physically settled, then, if true, a failure to deliver the shares on the settlement date will not be an event of default for the purposes of the master agreement.
	 *
	 */
	Boolean getFailureToDeliver();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision If true, then insolvency filing is applicable.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision If true, then insolvency filing is applicable.
	 *
	 */
	Boolean getInsolvencyFiling();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision If true, then hedging disruption is applicable.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision If true, then hedging disruption is applicable.
	 *
	 */
	Boolean getHedgingDisruption();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision If true, then loss of stock borrow is applicable.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision If true, then loss of stock borrow is applicable.
	 *
	 */
	Boolean getLossOfStockBorrow();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the maximum stock loan rate for Loss of Stock Borrow.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the maximum stock loan rate for Loss of Stock Borrow.
	 *
	 */
	BigDecimal getMaximumStockLoanRate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision If true, then increased cost of stock borrow is applicable.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision If true, then increased cost of stock borrow is applicable.
	 *
	 */
	Boolean getIncreasedCostOfStockBorrow();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the initial stock loan rate for Increased Cost of Stock Borrow.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the initial stock loan rate for Increased Cost of Stock Borrow.
	 *
	 */
	BigDecimal getInitialStockLoanRate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision If true, then increased cost of hedging is applicable.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision If true, then increased cost of hedging is applicable.
	 *
	 */
	Boolean getIncreasedCostOfHedging();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A reference to the party which determines additional disruption events.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A reference to the party which determines additional disruption events.
	 *
	 */
	PartyReference getDeterminingPartyReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision If true, then foreign ownership event is applicable.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision If true, then foreign ownership event is applicable.
	 *
	 */
	Boolean getForeignOwnershipEvent();

	/*********************** Build Methods  ***********************/
	AdditionalDisruptionEvents build();
	
	AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder toBuilder();
	
	static AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder builder() {
		return new AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AdditionalDisruptionEvents> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AdditionalDisruptionEvents> getType() {
		return AdditionalDisruptionEvents.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("changeInLaw"), Boolean.class, getChangeInLaw(), this);
		processor.processBasic(path.newSubPath("failureToDeliver"), Boolean.class, getFailureToDeliver(), this);
		processor.processBasic(path.newSubPath("insolvencyFiling"), Boolean.class, getInsolvencyFiling(), this);
		processor.processBasic(path.newSubPath("hedgingDisruption"), Boolean.class, getHedgingDisruption(), this);
		processor.processBasic(path.newSubPath("lossOfStockBorrow"), Boolean.class, getLossOfStockBorrow(), this);
		processor.processBasic(path.newSubPath("maximumStockLoanRate"), BigDecimal.class, getMaximumStockLoanRate(), this);
		processor.processBasic(path.newSubPath("increasedCostOfStockBorrow"), Boolean.class, getIncreasedCostOfStockBorrow(), this);
		processor.processBasic(path.newSubPath("initialStockLoanRate"), BigDecimal.class, getInitialStockLoanRate(), this);
		processor.processBasic(path.newSubPath("increasedCostOfHedging"), Boolean.class, getIncreasedCostOfHedging(), this);
		processRosetta(path.newSubPath("determiningPartyReference"), processor, PartyReference.class, getDeterminingPartyReference());
		processor.processBasic(path.newSubPath("foreignOwnershipEvent"), Boolean.class, getForeignOwnershipEvent(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface AdditionalDisruptionEventsBuilder extends AdditionalDisruptionEvents, RosettaModelObjectBuilder {
		PartyReference.PartyReferenceBuilder getOrCreateDeterminingPartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getDeterminingPartyReference();
		AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder setChangeInLaw(Boolean changeInLaw);
		AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder setFailureToDeliver(Boolean failureToDeliver);
		AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder setInsolvencyFiling(Boolean insolvencyFiling);
		AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder setHedgingDisruption(Boolean hedgingDisruption);
		AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder setLossOfStockBorrow(Boolean lossOfStockBorrow);
		AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder setMaximumStockLoanRate(BigDecimal maximumStockLoanRate);
		AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder setIncreasedCostOfStockBorrow(Boolean increasedCostOfStockBorrow);
		AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder setInitialStockLoanRate(BigDecimal initialStockLoanRate);
		AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder setIncreasedCostOfHedging(Boolean increasedCostOfHedging);
		AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder setDeterminingPartyReference(PartyReference determiningPartyReference);
		AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder setForeignOwnershipEvent(Boolean foreignOwnershipEvent);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("changeInLaw"), Boolean.class, getChangeInLaw(), this);
			processor.processBasic(path.newSubPath("failureToDeliver"), Boolean.class, getFailureToDeliver(), this);
			processor.processBasic(path.newSubPath("insolvencyFiling"), Boolean.class, getInsolvencyFiling(), this);
			processor.processBasic(path.newSubPath("hedgingDisruption"), Boolean.class, getHedgingDisruption(), this);
			processor.processBasic(path.newSubPath("lossOfStockBorrow"), Boolean.class, getLossOfStockBorrow(), this);
			processor.processBasic(path.newSubPath("maximumStockLoanRate"), BigDecimal.class, getMaximumStockLoanRate(), this);
			processor.processBasic(path.newSubPath("increasedCostOfStockBorrow"), Boolean.class, getIncreasedCostOfStockBorrow(), this);
			processor.processBasic(path.newSubPath("initialStockLoanRate"), BigDecimal.class, getInitialStockLoanRate(), this);
			processor.processBasic(path.newSubPath("increasedCostOfHedging"), Boolean.class, getIncreasedCostOfHedging(), this);
			processRosetta(path.newSubPath("determiningPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getDeterminingPartyReference());
			processor.processBasic(path.newSubPath("foreignOwnershipEvent"), Boolean.class, getForeignOwnershipEvent(), this);
		}
		

		AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder prune();
	}

	/*********************** Immutable Implementation of AdditionalDisruptionEvents  ***********************/
	class AdditionalDisruptionEventsImpl implements AdditionalDisruptionEvents {
		private final Boolean changeInLaw;
		private final Boolean failureToDeliver;
		private final Boolean insolvencyFiling;
		private final Boolean hedgingDisruption;
		private final Boolean lossOfStockBorrow;
		private final BigDecimal maximumStockLoanRate;
		private final Boolean increasedCostOfStockBorrow;
		private final BigDecimal initialStockLoanRate;
		private final Boolean increasedCostOfHedging;
		private final PartyReference determiningPartyReference;
		private final Boolean foreignOwnershipEvent;
		
		protected AdditionalDisruptionEventsImpl(AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder builder) {
			this.changeInLaw = builder.getChangeInLaw();
			this.failureToDeliver = builder.getFailureToDeliver();
			this.insolvencyFiling = builder.getInsolvencyFiling();
			this.hedgingDisruption = builder.getHedgingDisruption();
			this.lossOfStockBorrow = builder.getLossOfStockBorrow();
			this.maximumStockLoanRate = builder.getMaximumStockLoanRate();
			this.increasedCostOfStockBorrow = builder.getIncreasedCostOfStockBorrow();
			this.initialStockLoanRate = builder.getInitialStockLoanRate();
			this.increasedCostOfHedging = builder.getIncreasedCostOfHedging();
			this.determiningPartyReference = ofNullable(builder.getDeterminingPartyReference()).map(f->f.build()).orElse(null);
			this.foreignOwnershipEvent = builder.getForeignOwnershipEvent();
		}
		
		@Override
		@RosettaAttribute("changeInLaw")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("changeInLaw")
		public Boolean getChangeInLaw() {
			return changeInLaw;
		}
		
		@Override
		@RosettaAttribute("failureToDeliver")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("failureToDeliver")
		public Boolean getFailureToDeliver() {
			return failureToDeliver;
		}
		
		@Override
		@RosettaAttribute("insolvencyFiling")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("insolvencyFiling")
		public Boolean getInsolvencyFiling() {
			return insolvencyFiling;
		}
		
		@Override
		@RosettaAttribute("hedgingDisruption")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("hedgingDisruption")
		public Boolean getHedgingDisruption() {
			return hedgingDisruption;
		}
		
		@Override
		@RosettaAttribute("lossOfStockBorrow")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("lossOfStockBorrow")
		public Boolean getLossOfStockBorrow() {
			return lossOfStockBorrow;
		}
		
		@Override
		@RosettaAttribute("maximumStockLoanRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("maximumStockLoanRate")
		public BigDecimal getMaximumStockLoanRate() {
			return maximumStockLoanRate;
		}
		
		@Override
		@RosettaAttribute("increasedCostOfStockBorrow")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("increasedCostOfStockBorrow")
		public Boolean getIncreasedCostOfStockBorrow() {
			return increasedCostOfStockBorrow;
		}
		
		@Override
		@RosettaAttribute("initialStockLoanRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("initialStockLoanRate")
		public BigDecimal getInitialStockLoanRate() {
			return initialStockLoanRate;
		}
		
		@Override
		@RosettaAttribute("increasedCostOfHedging")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("increasedCostOfHedging")
		public Boolean getIncreasedCostOfHedging() {
			return increasedCostOfHedging;
		}
		
		@Override
		@RosettaAttribute("determiningPartyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("determiningPartyReference")
		public PartyReference getDeterminingPartyReference() {
			return determiningPartyReference;
		}
		
		@Override
		@RosettaAttribute("foreignOwnershipEvent")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("foreignOwnershipEvent")
		public Boolean getForeignOwnershipEvent() {
			return foreignOwnershipEvent;
		}
		
		@Override
		public AdditionalDisruptionEvents build() {
			return this;
		}
		
		@Override
		public AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder toBuilder() {
			AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder builder) {
			ofNullable(getChangeInLaw()).ifPresent(builder::setChangeInLaw);
			ofNullable(getFailureToDeliver()).ifPresent(builder::setFailureToDeliver);
			ofNullable(getInsolvencyFiling()).ifPresent(builder::setInsolvencyFiling);
			ofNullable(getHedgingDisruption()).ifPresent(builder::setHedgingDisruption);
			ofNullable(getLossOfStockBorrow()).ifPresent(builder::setLossOfStockBorrow);
			ofNullable(getMaximumStockLoanRate()).ifPresent(builder::setMaximumStockLoanRate);
			ofNullable(getIncreasedCostOfStockBorrow()).ifPresent(builder::setIncreasedCostOfStockBorrow);
			ofNullable(getInitialStockLoanRate()).ifPresent(builder::setInitialStockLoanRate);
			ofNullable(getIncreasedCostOfHedging()).ifPresent(builder::setIncreasedCostOfHedging);
			ofNullable(getDeterminingPartyReference()).ifPresent(builder::setDeterminingPartyReference);
			ofNullable(getForeignOwnershipEvent()).ifPresent(builder::setForeignOwnershipEvent);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AdditionalDisruptionEvents _that = getType().cast(o);
		
			if (!Objects.equals(changeInLaw, _that.getChangeInLaw())) return false;
			if (!Objects.equals(failureToDeliver, _that.getFailureToDeliver())) return false;
			if (!Objects.equals(insolvencyFiling, _that.getInsolvencyFiling())) return false;
			if (!Objects.equals(hedgingDisruption, _that.getHedgingDisruption())) return false;
			if (!Objects.equals(lossOfStockBorrow, _that.getLossOfStockBorrow())) return false;
			if (!Objects.equals(maximumStockLoanRate, _that.getMaximumStockLoanRate())) return false;
			if (!Objects.equals(increasedCostOfStockBorrow, _that.getIncreasedCostOfStockBorrow())) return false;
			if (!Objects.equals(initialStockLoanRate, _that.getInitialStockLoanRate())) return false;
			if (!Objects.equals(increasedCostOfHedging, _that.getIncreasedCostOfHedging())) return false;
			if (!Objects.equals(determiningPartyReference, _that.getDeterminingPartyReference())) return false;
			if (!Objects.equals(foreignOwnershipEvent, _that.getForeignOwnershipEvent())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (changeInLaw != null ? changeInLaw.hashCode() : 0);
			_result = 31 * _result + (failureToDeliver != null ? failureToDeliver.hashCode() : 0);
			_result = 31 * _result + (insolvencyFiling != null ? insolvencyFiling.hashCode() : 0);
			_result = 31 * _result + (hedgingDisruption != null ? hedgingDisruption.hashCode() : 0);
			_result = 31 * _result + (lossOfStockBorrow != null ? lossOfStockBorrow.hashCode() : 0);
			_result = 31 * _result + (maximumStockLoanRate != null ? maximumStockLoanRate.hashCode() : 0);
			_result = 31 * _result + (increasedCostOfStockBorrow != null ? increasedCostOfStockBorrow.hashCode() : 0);
			_result = 31 * _result + (initialStockLoanRate != null ? initialStockLoanRate.hashCode() : 0);
			_result = 31 * _result + (increasedCostOfHedging != null ? increasedCostOfHedging.hashCode() : 0);
			_result = 31 * _result + (determiningPartyReference != null ? determiningPartyReference.hashCode() : 0);
			_result = 31 * _result + (foreignOwnershipEvent != null ? foreignOwnershipEvent.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AdditionalDisruptionEvents {" +
				"changeInLaw=" + this.changeInLaw + ", " +
				"failureToDeliver=" + this.failureToDeliver + ", " +
				"insolvencyFiling=" + this.insolvencyFiling + ", " +
				"hedgingDisruption=" + this.hedgingDisruption + ", " +
				"lossOfStockBorrow=" + this.lossOfStockBorrow + ", " +
				"maximumStockLoanRate=" + this.maximumStockLoanRate + ", " +
				"increasedCostOfStockBorrow=" + this.increasedCostOfStockBorrow + ", " +
				"initialStockLoanRate=" + this.initialStockLoanRate + ", " +
				"increasedCostOfHedging=" + this.increasedCostOfHedging + ", " +
				"determiningPartyReference=" + this.determiningPartyReference + ", " +
				"foreignOwnershipEvent=" + this.foreignOwnershipEvent +
			'}';
		}
	}

	/*********************** Builder Implementation of AdditionalDisruptionEvents  ***********************/
	class AdditionalDisruptionEventsBuilderImpl implements AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder {
	
		protected Boolean changeInLaw;
		protected Boolean failureToDeliver;
		protected Boolean insolvencyFiling;
		protected Boolean hedgingDisruption;
		protected Boolean lossOfStockBorrow;
		protected BigDecimal maximumStockLoanRate;
		protected Boolean increasedCostOfStockBorrow;
		protected BigDecimal initialStockLoanRate;
		protected Boolean increasedCostOfHedging;
		protected PartyReference.PartyReferenceBuilder determiningPartyReference;
		protected Boolean foreignOwnershipEvent;
		
		@Override
		@RosettaAttribute("changeInLaw")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("changeInLaw")
		public Boolean getChangeInLaw() {
			return changeInLaw;
		}
		
		@Override
		@RosettaAttribute("failureToDeliver")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("failureToDeliver")
		public Boolean getFailureToDeliver() {
			return failureToDeliver;
		}
		
		@Override
		@RosettaAttribute("insolvencyFiling")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("insolvencyFiling")
		public Boolean getInsolvencyFiling() {
			return insolvencyFiling;
		}
		
		@Override
		@RosettaAttribute("hedgingDisruption")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("hedgingDisruption")
		public Boolean getHedgingDisruption() {
			return hedgingDisruption;
		}
		
		@Override
		@RosettaAttribute("lossOfStockBorrow")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("lossOfStockBorrow")
		public Boolean getLossOfStockBorrow() {
			return lossOfStockBorrow;
		}
		
		@Override
		@RosettaAttribute("maximumStockLoanRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("maximumStockLoanRate")
		public BigDecimal getMaximumStockLoanRate() {
			return maximumStockLoanRate;
		}
		
		@Override
		@RosettaAttribute("increasedCostOfStockBorrow")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("increasedCostOfStockBorrow")
		public Boolean getIncreasedCostOfStockBorrow() {
			return increasedCostOfStockBorrow;
		}
		
		@Override
		@RosettaAttribute("initialStockLoanRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("initialStockLoanRate")
		public BigDecimal getInitialStockLoanRate() {
			return initialStockLoanRate;
		}
		
		@Override
		@RosettaAttribute("increasedCostOfHedging")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("increasedCostOfHedging")
		public Boolean getIncreasedCostOfHedging() {
			return increasedCostOfHedging;
		}
		
		@Override
		@RosettaAttribute("determiningPartyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("determiningPartyReference")
		public PartyReference.PartyReferenceBuilder getDeterminingPartyReference() {
			return determiningPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateDeterminingPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (determiningPartyReference!=null) {
				result = determiningPartyReference;
			}
			else {
				result = determiningPartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("foreignOwnershipEvent")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("foreignOwnershipEvent")
		public Boolean getForeignOwnershipEvent() {
			return foreignOwnershipEvent;
		}
		
		@RosettaAttribute("changeInLaw")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("changeInLaw")
		@Override
		public AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder setChangeInLaw(Boolean _changeInLaw) {
			this.changeInLaw = _changeInLaw == null ? null : _changeInLaw;
			return this;
		}
		
		@RosettaAttribute("failureToDeliver")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("failureToDeliver")
		@Override
		public AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder setFailureToDeliver(Boolean _failureToDeliver) {
			this.failureToDeliver = _failureToDeliver == null ? null : _failureToDeliver;
			return this;
		}
		
		@RosettaAttribute("insolvencyFiling")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("insolvencyFiling")
		@Override
		public AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder setInsolvencyFiling(Boolean _insolvencyFiling) {
			this.insolvencyFiling = _insolvencyFiling == null ? null : _insolvencyFiling;
			return this;
		}
		
		@RosettaAttribute("hedgingDisruption")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("hedgingDisruption")
		@Override
		public AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder setHedgingDisruption(Boolean _hedgingDisruption) {
			this.hedgingDisruption = _hedgingDisruption == null ? null : _hedgingDisruption;
			return this;
		}
		
		@RosettaAttribute("lossOfStockBorrow")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lossOfStockBorrow")
		@Override
		public AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder setLossOfStockBorrow(Boolean _lossOfStockBorrow) {
			this.lossOfStockBorrow = _lossOfStockBorrow == null ? null : _lossOfStockBorrow;
			return this;
		}
		
		@RosettaAttribute("maximumStockLoanRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("maximumStockLoanRate")
		@Override
		public AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder setMaximumStockLoanRate(BigDecimal _maximumStockLoanRate) {
			this.maximumStockLoanRate = _maximumStockLoanRate == null ? null : _maximumStockLoanRate;
			return this;
		}
		
		@RosettaAttribute("increasedCostOfStockBorrow")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("increasedCostOfStockBorrow")
		@Override
		public AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder setIncreasedCostOfStockBorrow(Boolean _increasedCostOfStockBorrow) {
			this.increasedCostOfStockBorrow = _increasedCostOfStockBorrow == null ? null : _increasedCostOfStockBorrow;
			return this;
		}
		
		@RosettaAttribute("initialStockLoanRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("initialStockLoanRate")
		@Override
		public AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder setInitialStockLoanRate(BigDecimal _initialStockLoanRate) {
			this.initialStockLoanRate = _initialStockLoanRate == null ? null : _initialStockLoanRate;
			return this;
		}
		
		@RosettaAttribute("increasedCostOfHedging")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("increasedCostOfHedging")
		@Override
		public AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder setIncreasedCostOfHedging(Boolean _increasedCostOfHedging) {
			this.increasedCostOfHedging = _increasedCostOfHedging == null ? null : _increasedCostOfHedging;
			return this;
		}
		
		@RosettaAttribute("determiningPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("determiningPartyReference")
		@Override
		public AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder setDeterminingPartyReference(PartyReference _determiningPartyReference) {
			this.determiningPartyReference = _determiningPartyReference == null ? null : _determiningPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("foreignOwnershipEvent")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("foreignOwnershipEvent")
		@Override
		public AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder setForeignOwnershipEvent(Boolean _foreignOwnershipEvent) {
			this.foreignOwnershipEvent = _foreignOwnershipEvent == null ? null : _foreignOwnershipEvent;
			return this;
		}
		
		@Override
		public AdditionalDisruptionEvents build() {
			return new AdditionalDisruptionEvents.AdditionalDisruptionEventsImpl(this);
		}
		
		@Override
		public AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder prune() {
			if (determiningPartyReference!=null && !determiningPartyReference.prune().hasData()) determiningPartyReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getChangeInLaw()!=null) return true;
			if (getFailureToDeliver()!=null) return true;
			if (getInsolvencyFiling()!=null) return true;
			if (getHedgingDisruption()!=null) return true;
			if (getLossOfStockBorrow()!=null) return true;
			if (getMaximumStockLoanRate()!=null) return true;
			if (getIncreasedCostOfStockBorrow()!=null) return true;
			if (getInitialStockLoanRate()!=null) return true;
			if (getIncreasedCostOfHedging()!=null) return true;
			if (getDeterminingPartyReference()!=null && getDeterminingPartyReference().hasData()) return true;
			if (getForeignOwnershipEvent()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder o = (AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder) other;
			
			merger.mergeRosetta(getDeterminingPartyReference(), o.getDeterminingPartyReference(), this::setDeterminingPartyReference);
			
			merger.mergeBasic(getChangeInLaw(), o.getChangeInLaw(), this::setChangeInLaw);
			merger.mergeBasic(getFailureToDeliver(), o.getFailureToDeliver(), this::setFailureToDeliver);
			merger.mergeBasic(getInsolvencyFiling(), o.getInsolvencyFiling(), this::setInsolvencyFiling);
			merger.mergeBasic(getHedgingDisruption(), o.getHedgingDisruption(), this::setHedgingDisruption);
			merger.mergeBasic(getLossOfStockBorrow(), o.getLossOfStockBorrow(), this::setLossOfStockBorrow);
			merger.mergeBasic(getMaximumStockLoanRate(), o.getMaximumStockLoanRate(), this::setMaximumStockLoanRate);
			merger.mergeBasic(getIncreasedCostOfStockBorrow(), o.getIncreasedCostOfStockBorrow(), this::setIncreasedCostOfStockBorrow);
			merger.mergeBasic(getInitialStockLoanRate(), o.getInitialStockLoanRate(), this::setInitialStockLoanRate);
			merger.mergeBasic(getIncreasedCostOfHedging(), o.getIncreasedCostOfHedging(), this::setIncreasedCostOfHedging);
			merger.mergeBasic(getForeignOwnershipEvent(), o.getForeignOwnershipEvent(), this::setForeignOwnershipEvent);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AdditionalDisruptionEvents _that = getType().cast(o);
		
			if (!Objects.equals(changeInLaw, _that.getChangeInLaw())) return false;
			if (!Objects.equals(failureToDeliver, _that.getFailureToDeliver())) return false;
			if (!Objects.equals(insolvencyFiling, _that.getInsolvencyFiling())) return false;
			if (!Objects.equals(hedgingDisruption, _that.getHedgingDisruption())) return false;
			if (!Objects.equals(lossOfStockBorrow, _that.getLossOfStockBorrow())) return false;
			if (!Objects.equals(maximumStockLoanRate, _that.getMaximumStockLoanRate())) return false;
			if (!Objects.equals(increasedCostOfStockBorrow, _that.getIncreasedCostOfStockBorrow())) return false;
			if (!Objects.equals(initialStockLoanRate, _that.getInitialStockLoanRate())) return false;
			if (!Objects.equals(increasedCostOfHedging, _that.getIncreasedCostOfHedging())) return false;
			if (!Objects.equals(determiningPartyReference, _that.getDeterminingPartyReference())) return false;
			if (!Objects.equals(foreignOwnershipEvent, _that.getForeignOwnershipEvent())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (changeInLaw != null ? changeInLaw.hashCode() : 0);
			_result = 31 * _result + (failureToDeliver != null ? failureToDeliver.hashCode() : 0);
			_result = 31 * _result + (insolvencyFiling != null ? insolvencyFiling.hashCode() : 0);
			_result = 31 * _result + (hedgingDisruption != null ? hedgingDisruption.hashCode() : 0);
			_result = 31 * _result + (lossOfStockBorrow != null ? lossOfStockBorrow.hashCode() : 0);
			_result = 31 * _result + (maximumStockLoanRate != null ? maximumStockLoanRate.hashCode() : 0);
			_result = 31 * _result + (increasedCostOfStockBorrow != null ? increasedCostOfStockBorrow.hashCode() : 0);
			_result = 31 * _result + (initialStockLoanRate != null ? initialStockLoanRate.hashCode() : 0);
			_result = 31 * _result + (increasedCostOfHedging != null ? increasedCostOfHedging.hashCode() : 0);
			_result = 31 * _result + (determiningPartyReference != null ? determiningPartyReference.hashCode() : 0);
			_result = 31 * _result + (foreignOwnershipEvent != null ? foreignOwnershipEvent.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AdditionalDisruptionEventsBuilder {" +
				"changeInLaw=" + this.changeInLaw + ", " +
				"failureToDeliver=" + this.failureToDeliver + ", " +
				"insolvencyFiling=" + this.insolvencyFiling + ", " +
				"hedgingDisruption=" + this.hedgingDisruption + ", " +
				"lossOfStockBorrow=" + this.lossOfStockBorrow + ", " +
				"maximumStockLoanRate=" + this.maximumStockLoanRate + ", " +
				"increasedCostOfStockBorrow=" + this.increasedCostOfStockBorrow + ", " +
				"initialStockLoanRate=" + this.initialStockLoanRate + ", " +
				"increasedCostOfHedging=" + this.increasedCostOfHedging + ", " +
				"determiningPartyReference=" + this.determiningPartyReference + ", " +
				"foreignOwnershipEvent=" + this.foreignOwnershipEvent +
			'}';
		}
	}
}
