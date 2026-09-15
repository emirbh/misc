package fpml.consolidated.accumulator;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Required;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.consolidated.accumulator.meta.ObservationPeriodMeta;
import java.time.ZonedDateTime;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Period when accumulator will accumulate shares.
 *
 */
@RosettaDataType(value="ObservationPeriod", builder=ObservationPeriod.ObservationPeriodBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ObservationPeriod", model="fpml", builder=ObservationPeriod.ObservationPeriodBuilderImpl.class, version="2.1.1")
public interface ObservationPeriod extends RosettaModelObject {

	ObservationPeriodMeta metaData = new ObservationPeriodMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Start date of observation period
	 *
	 */
	ZonedDateTime getObservationPeriodStartDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision End date of observation period
	 *
	 */
	ZonedDateTime getObservationPeriodEndDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Settlement date for shares accumulated during the observation period.
	 *
	 */
	ZonedDateTime getObservationPeriodSettlementDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Number of trading days in observation period
	 *
	 */
	Integer getObservationPeriodNoOfTradingDays();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Does the investor need to invest the maximum notional amount for this observation period upfront ? The alternative is to transact on a margin basis.
	 *
	 */
	Boolean getUpFrontSettlement();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Number of scheduled trading days in observation period
	 *
	 */
	Integer getNoOfScheduledTradingDays();

	/*********************** Build Methods  ***********************/
	ObservationPeriod build();
	
	ObservationPeriod.ObservationPeriodBuilder toBuilder();
	
	static ObservationPeriod.ObservationPeriodBuilder builder() {
		return new ObservationPeriod.ObservationPeriodBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ObservationPeriod> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ObservationPeriod> getType() {
		return ObservationPeriod.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("observationPeriodStartDate"), ZonedDateTime.class, getObservationPeriodStartDate(), this);
		processor.processBasic(path.newSubPath("observationPeriodEndDate"), ZonedDateTime.class, getObservationPeriodEndDate(), this);
		processor.processBasic(path.newSubPath("observationPeriodSettlementDate"), ZonedDateTime.class, getObservationPeriodSettlementDate(), this);
		processor.processBasic(path.newSubPath("observationPeriodNoOfTradingDays"), Integer.class, getObservationPeriodNoOfTradingDays(), this);
		processor.processBasic(path.newSubPath("upFrontSettlement"), Boolean.class, getUpFrontSettlement(), this);
		processor.processBasic(path.newSubPath("noOfScheduledTradingDays"), Integer.class, getNoOfScheduledTradingDays(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ObservationPeriodBuilder extends ObservationPeriod, RosettaModelObjectBuilder {
		ObservationPeriod.ObservationPeriodBuilder setObservationPeriodStartDate(ZonedDateTime observationPeriodStartDate);
		ObservationPeriod.ObservationPeriodBuilder setObservationPeriodEndDate(ZonedDateTime observationPeriodEndDate);
		ObservationPeriod.ObservationPeriodBuilder setObservationPeriodSettlementDate(ZonedDateTime observationPeriodSettlementDate);
		ObservationPeriod.ObservationPeriodBuilder setObservationPeriodNoOfTradingDays(Integer observationPeriodNoOfTradingDays);
		ObservationPeriod.ObservationPeriodBuilder setUpFrontSettlement(Boolean upFrontSettlement);
		ObservationPeriod.ObservationPeriodBuilder setNoOfScheduledTradingDays(Integer noOfScheduledTradingDays);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("observationPeriodStartDate"), ZonedDateTime.class, getObservationPeriodStartDate(), this);
			processor.processBasic(path.newSubPath("observationPeriodEndDate"), ZonedDateTime.class, getObservationPeriodEndDate(), this);
			processor.processBasic(path.newSubPath("observationPeriodSettlementDate"), ZonedDateTime.class, getObservationPeriodSettlementDate(), this);
			processor.processBasic(path.newSubPath("observationPeriodNoOfTradingDays"), Integer.class, getObservationPeriodNoOfTradingDays(), this);
			processor.processBasic(path.newSubPath("upFrontSettlement"), Boolean.class, getUpFrontSettlement(), this);
			processor.processBasic(path.newSubPath("noOfScheduledTradingDays"), Integer.class, getNoOfScheduledTradingDays(), this);
		}
		

		ObservationPeriod.ObservationPeriodBuilder prune();
	}

	/*********************** Immutable Implementation of ObservationPeriod  ***********************/
	class ObservationPeriodImpl implements ObservationPeriod {
		private final ZonedDateTime observationPeriodStartDate;
		private final ZonedDateTime observationPeriodEndDate;
		private final ZonedDateTime observationPeriodSettlementDate;
		private final Integer observationPeriodNoOfTradingDays;
		private final Boolean upFrontSettlement;
		private final Integer noOfScheduledTradingDays;
		
		protected ObservationPeriodImpl(ObservationPeriod.ObservationPeriodBuilder builder) {
			this.observationPeriodStartDate = builder.getObservationPeriodStartDate();
			this.observationPeriodEndDate = builder.getObservationPeriodEndDate();
			this.observationPeriodSettlementDate = builder.getObservationPeriodSettlementDate();
			this.observationPeriodNoOfTradingDays = builder.getObservationPeriodNoOfTradingDays();
			this.upFrontSettlement = builder.getUpFrontSettlement();
			this.noOfScheduledTradingDays = builder.getNoOfScheduledTradingDays();
		}
		
		@Override
		@RosettaAttribute("observationPeriodStartDate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("observationPeriodStartDate")
		public ZonedDateTime getObservationPeriodStartDate() {
			return observationPeriodStartDate;
		}
		
		@Override
		@RosettaAttribute("observationPeriodEndDate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("observationPeriodEndDate")
		public ZonedDateTime getObservationPeriodEndDate() {
			return observationPeriodEndDate;
		}
		
		@Override
		@RosettaAttribute("observationPeriodSettlementDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("observationPeriodSettlementDate")
		public ZonedDateTime getObservationPeriodSettlementDate() {
			return observationPeriodSettlementDate;
		}
		
		@Override
		@RosettaAttribute("observationPeriodNoOfTradingDays")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("observationPeriodNoOfTradingDays")
		public Integer getObservationPeriodNoOfTradingDays() {
			return observationPeriodNoOfTradingDays;
		}
		
		@Override
		@RosettaAttribute("upFrontSettlement")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("upFrontSettlement")
		public Boolean getUpFrontSettlement() {
			return upFrontSettlement;
		}
		
		@Override
		@RosettaAttribute("noOfScheduledTradingDays")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("noOfScheduledTradingDays")
		public Integer getNoOfScheduledTradingDays() {
			return noOfScheduledTradingDays;
		}
		
		@Override
		public ObservationPeriod build() {
			return this;
		}
		
		@Override
		public ObservationPeriod.ObservationPeriodBuilder toBuilder() {
			ObservationPeriod.ObservationPeriodBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ObservationPeriod.ObservationPeriodBuilder builder) {
			ofNullable(getObservationPeriodStartDate()).ifPresent(builder::setObservationPeriodStartDate);
			ofNullable(getObservationPeriodEndDate()).ifPresent(builder::setObservationPeriodEndDate);
			ofNullable(getObservationPeriodSettlementDate()).ifPresent(builder::setObservationPeriodSettlementDate);
			ofNullable(getObservationPeriodNoOfTradingDays()).ifPresent(builder::setObservationPeriodNoOfTradingDays);
			ofNullable(getUpFrontSettlement()).ifPresent(builder::setUpFrontSettlement);
			ofNullable(getNoOfScheduledTradingDays()).ifPresent(builder::setNoOfScheduledTradingDays);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ObservationPeriod _that = getType().cast(o);
		
			if (!Objects.equals(observationPeriodStartDate, _that.getObservationPeriodStartDate())) return false;
			if (!Objects.equals(observationPeriodEndDate, _that.getObservationPeriodEndDate())) return false;
			if (!Objects.equals(observationPeriodSettlementDate, _that.getObservationPeriodSettlementDate())) return false;
			if (!Objects.equals(observationPeriodNoOfTradingDays, _that.getObservationPeriodNoOfTradingDays())) return false;
			if (!Objects.equals(upFrontSettlement, _that.getUpFrontSettlement())) return false;
			if (!Objects.equals(noOfScheduledTradingDays, _that.getNoOfScheduledTradingDays())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (observationPeriodStartDate != null ? observationPeriodStartDate.hashCode() : 0);
			_result = 31 * _result + (observationPeriodEndDate != null ? observationPeriodEndDate.hashCode() : 0);
			_result = 31 * _result + (observationPeriodSettlementDate != null ? observationPeriodSettlementDate.hashCode() : 0);
			_result = 31 * _result + (observationPeriodNoOfTradingDays != null ? observationPeriodNoOfTradingDays.hashCode() : 0);
			_result = 31 * _result + (upFrontSettlement != null ? upFrontSettlement.hashCode() : 0);
			_result = 31 * _result + (noOfScheduledTradingDays != null ? noOfScheduledTradingDays.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ObservationPeriod {" +
				"observationPeriodStartDate=" + this.observationPeriodStartDate + ", " +
				"observationPeriodEndDate=" + this.observationPeriodEndDate + ", " +
				"observationPeriodSettlementDate=" + this.observationPeriodSettlementDate + ", " +
				"observationPeriodNoOfTradingDays=" + this.observationPeriodNoOfTradingDays + ", " +
				"upFrontSettlement=" + this.upFrontSettlement + ", " +
				"noOfScheduledTradingDays=" + this.noOfScheduledTradingDays +
			'}';
		}
	}

	/*********************** Builder Implementation of ObservationPeriod  ***********************/
	class ObservationPeriodBuilderImpl implements ObservationPeriod.ObservationPeriodBuilder {
	
		protected ZonedDateTime observationPeriodStartDate;
		protected ZonedDateTime observationPeriodEndDate;
		protected ZonedDateTime observationPeriodSettlementDate;
		protected Integer observationPeriodNoOfTradingDays;
		protected Boolean upFrontSettlement;
		protected Integer noOfScheduledTradingDays;
		
		@Override
		@RosettaAttribute("observationPeriodStartDate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("observationPeriodStartDate")
		public ZonedDateTime getObservationPeriodStartDate() {
			return observationPeriodStartDate;
		}
		
		@Override
		@RosettaAttribute("observationPeriodEndDate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("observationPeriodEndDate")
		public ZonedDateTime getObservationPeriodEndDate() {
			return observationPeriodEndDate;
		}
		
		@Override
		@RosettaAttribute("observationPeriodSettlementDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("observationPeriodSettlementDate")
		public ZonedDateTime getObservationPeriodSettlementDate() {
			return observationPeriodSettlementDate;
		}
		
		@Override
		@RosettaAttribute("observationPeriodNoOfTradingDays")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("observationPeriodNoOfTradingDays")
		public Integer getObservationPeriodNoOfTradingDays() {
			return observationPeriodNoOfTradingDays;
		}
		
		@Override
		@RosettaAttribute("upFrontSettlement")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("upFrontSettlement")
		public Boolean getUpFrontSettlement() {
			return upFrontSettlement;
		}
		
		@Override
		@RosettaAttribute("noOfScheduledTradingDays")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("noOfScheduledTradingDays")
		public Integer getNoOfScheduledTradingDays() {
			return noOfScheduledTradingDays;
		}
		
		@RosettaAttribute("observationPeriodStartDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("observationPeriodStartDate")
		@Override
		public ObservationPeriod.ObservationPeriodBuilder setObservationPeriodStartDate(ZonedDateTime _observationPeriodStartDate) {
			this.observationPeriodStartDate = _observationPeriodStartDate == null ? null : _observationPeriodStartDate;
			return this;
		}
		
		@RosettaAttribute("observationPeriodEndDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("observationPeriodEndDate")
		@Override
		public ObservationPeriod.ObservationPeriodBuilder setObservationPeriodEndDate(ZonedDateTime _observationPeriodEndDate) {
			this.observationPeriodEndDate = _observationPeriodEndDate == null ? null : _observationPeriodEndDate;
			return this;
		}
		
		@RosettaAttribute("observationPeriodSettlementDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("observationPeriodSettlementDate")
		@Override
		public ObservationPeriod.ObservationPeriodBuilder setObservationPeriodSettlementDate(ZonedDateTime _observationPeriodSettlementDate) {
			this.observationPeriodSettlementDate = _observationPeriodSettlementDate == null ? null : _observationPeriodSettlementDate;
			return this;
		}
		
		@RosettaAttribute("observationPeriodNoOfTradingDays")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("observationPeriodNoOfTradingDays")
		@Override
		public ObservationPeriod.ObservationPeriodBuilder setObservationPeriodNoOfTradingDays(Integer _observationPeriodNoOfTradingDays) {
			this.observationPeriodNoOfTradingDays = _observationPeriodNoOfTradingDays == null ? null : _observationPeriodNoOfTradingDays;
			return this;
		}
		
		@RosettaAttribute("upFrontSettlement")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("upFrontSettlement")
		@Override
		public ObservationPeriod.ObservationPeriodBuilder setUpFrontSettlement(Boolean _upFrontSettlement) {
			this.upFrontSettlement = _upFrontSettlement == null ? null : _upFrontSettlement;
			return this;
		}
		
		@RosettaAttribute("noOfScheduledTradingDays")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("noOfScheduledTradingDays")
		@Override
		public ObservationPeriod.ObservationPeriodBuilder setNoOfScheduledTradingDays(Integer _noOfScheduledTradingDays) {
			this.noOfScheduledTradingDays = _noOfScheduledTradingDays == null ? null : _noOfScheduledTradingDays;
			return this;
		}
		
		@Override
		public ObservationPeriod build() {
			return new ObservationPeriod.ObservationPeriodImpl(this);
		}
		
		@Override
		public ObservationPeriod.ObservationPeriodBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ObservationPeriod.ObservationPeriodBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getObservationPeriodStartDate()!=null) return true;
			if (getObservationPeriodEndDate()!=null) return true;
			if (getObservationPeriodSettlementDate()!=null) return true;
			if (getObservationPeriodNoOfTradingDays()!=null) return true;
			if (getUpFrontSettlement()!=null) return true;
			if (getNoOfScheduledTradingDays()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ObservationPeriod.ObservationPeriodBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ObservationPeriod.ObservationPeriodBuilder o = (ObservationPeriod.ObservationPeriodBuilder) other;
			
			
			merger.mergeBasic(getObservationPeriodStartDate(), o.getObservationPeriodStartDate(), this::setObservationPeriodStartDate);
			merger.mergeBasic(getObservationPeriodEndDate(), o.getObservationPeriodEndDate(), this::setObservationPeriodEndDate);
			merger.mergeBasic(getObservationPeriodSettlementDate(), o.getObservationPeriodSettlementDate(), this::setObservationPeriodSettlementDate);
			merger.mergeBasic(getObservationPeriodNoOfTradingDays(), o.getObservationPeriodNoOfTradingDays(), this::setObservationPeriodNoOfTradingDays);
			merger.mergeBasic(getUpFrontSettlement(), o.getUpFrontSettlement(), this::setUpFrontSettlement);
			merger.mergeBasic(getNoOfScheduledTradingDays(), o.getNoOfScheduledTradingDays(), this::setNoOfScheduledTradingDays);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ObservationPeriod _that = getType().cast(o);
		
			if (!Objects.equals(observationPeriodStartDate, _that.getObservationPeriodStartDate())) return false;
			if (!Objects.equals(observationPeriodEndDate, _that.getObservationPeriodEndDate())) return false;
			if (!Objects.equals(observationPeriodSettlementDate, _that.getObservationPeriodSettlementDate())) return false;
			if (!Objects.equals(observationPeriodNoOfTradingDays, _that.getObservationPeriodNoOfTradingDays())) return false;
			if (!Objects.equals(upFrontSettlement, _that.getUpFrontSettlement())) return false;
			if (!Objects.equals(noOfScheduledTradingDays, _that.getNoOfScheduledTradingDays())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (observationPeriodStartDate != null ? observationPeriodStartDate.hashCode() : 0);
			_result = 31 * _result + (observationPeriodEndDate != null ? observationPeriodEndDate.hashCode() : 0);
			_result = 31 * _result + (observationPeriodSettlementDate != null ? observationPeriodSettlementDate.hashCode() : 0);
			_result = 31 * _result + (observationPeriodNoOfTradingDays != null ? observationPeriodNoOfTradingDays.hashCode() : 0);
			_result = 31 * _result + (upFrontSettlement != null ? upFrontSettlement.hashCode() : 0);
			_result = 31 * _result + (noOfScheduledTradingDays != null ? noOfScheduledTradingDays.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ObservationPeriodBuilder {" +
				"observationPeriodStartDate=" + this.observationPeriodStartDate + ", " +
				"observationPeriodEndDate=" + this.observationPeriodEndDate + ", " +
				"observationPeriodSettlementDate=" + this.observationPeriodSettlementDate + ", " +
				"observationPeriodNoOfTradingDays=" + this.observationPeriodNoOfTradingDays + ", " +
				"upFrontSettlement=" + this.upFrontSettlement + ", " +
				"noOfScheduledTradingDays=" + this.noOfScheduledTradingDays +
			'}';
		}
	}
}
