package fpml.consolidated.com;

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
import fpml.consolidated.com.meta.CommodityCalculationPeriodsScheduleMeta;
import fpml.consolidated.fpmlenum.PeriodExtendedEnum;
import fpml.consolidated.shared.Frequency;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A parametric representation of the Calculation Periods for on Asian option or a leg of a swap. In case the calculation frequency is of value T (term), the period is defined by the commoditySwap\effectiveDate and the commoditySwap\terminationDate.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A parametric representation of the Calculation Periods for on Asian option or a leg of a swap. In case the calculation frequency is of value T (term), the period is defined by the commoditySwap\effectiveDate and the commoditySwap\terminationDate.
 *
 */
@RosettaDataType(value="CommodityCalculationPeriodsSchedule", builder=CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CommodityCalculationPeriodsSchedule", model="fpml", builder=CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilderImpl.class, version="2.1.1")
public interface CommodityCalculationPeriodsSchedule extends Frequency {

	CommodityCalculationPeriodsScheduleMeta metaData = new CommodityCalculationPeriodsScheduleMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision If true, indicates that that the first Calculation Period should run from the Effective Date to the end of the calendar period in which the Effective Date falls, e.g. Jan 15 - Jan 31 if the calculation periods are one month long and Effective Date is Jan 15. If false, the first Calculation Period should run from the Effective Date for one whole period, e.g. Jan 15 to Feb 14 if the calculation periods are one month long and Effective Date is Jan 15.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision If true, indicates that that the first Calculation Period should run from the Effective Date to the end of the calendar period in which the Effective Date falls, e.g. Jan 15 - Jan 31 if the calculation periods are one month long and Effective Date is Jan 15. If false, the first Calculation Period should run from the Effective Date for one whole period, e.g. Jan 15 to Feb 14 if the calculation periods are one month long and Effective Date is Jan 15.
	 *
	 */
	Boolean getBalanceOfFirstPeriod();

	/*********************** Build Methods  ***********************/
	CommodityCalculationPeriodsSchedule build();
	
	CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder toBuilder();
	
	static CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder builder() {
		return new CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityCalculationPeriodsSchedule> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CommodityCalculationPeriodsSchedule> getType() {
		return CommodityCalculationPeriodsSchedule.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("periodMultiplier"), Integer.class, getPeriodMultiplier(), this);
		processor.processBasic(path.newSubPath("period"), PeriodExtendedEnum.class, getPeriod(), this);
		processor.processBasic(path.newSubPath("balanceOfFirstPeriod"), Boolean.class, getBalanceOfFirstPeriod(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityCalculationPeriodsScheduleBuilder extends CommodityCalculationPeriodsSchedule, Frequency.FrequencyBuilder {
		@Override
		CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder setId(String id);
		@Override
		CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder setPeriodMultiplier(Integer periodMultiplier);
		@Override
		CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder setPeriod(PeriodExtendedEnum period);
		CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder setBalanceOfFirstPeriod(Boolean balanceOfFirstPeriod);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("periodMultiplier"), Integer.class, getPeriodMultiplier(), this);
			processor.processBasic(path.newSubPath("period"), PeriodExtendedEnum.class, getPeriod(), this);
			processor.processBasic(path.newSubPath("balanceOfFirstPeriod"), Boolean.class, getBalanceOfFirstPeriod(), this);
		}
		

		CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityCalculationPeriodsSchedule  ***********************/
	class CommodityCalculationPeriodsScheduleImpl extends Frequency.FrequencyImpl implements CommodityCalculationPeriodsSchedule {
		private final Boolean balanceOfFirstPeriod;
		
		protected CommodityCalculationPeriodsScheduleImpl(CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder builder) {
			super(builder);
			this.balanceOfFirstPeriod = builder.getBalanceOfFirstPeriod();
		}
		
		@Override
		@RosettaAttribute("balanceOfFirstPeriod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("balanceOfFirstPeriod")
		public Boolean getBalanceOfFirstPeriod() {
			return balanceOfFirstPeriod;
		}
		
		@Override
		public CommodityCalculationPeriodsSchedule build() {
			return this;
		}
		
		@Override
		public CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder toBuilder() {
			CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getBalanceOfFirstPeriod()).ifPresent(builder::setBalanceOfFirstPeriod);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CommodityCalculationPeriodsSchedule _that = getType().cast(o);
		
			if (!Objects.equals(balanceOfFirstPeriod, _that.getBalanceOfFirstPeriod())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (balanceOfFirstPeriod != null ? balanceOfFirstPeriod.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityCalculationPeriodsSchedule {" +
				"balanceOfFirstPeriod=" + this.balanceOfFirstPeriod +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CommodityCalculationPeriodsSchedule  ***********************/
	class CommodityCalculationPeriodsScheduleBuilderImpl extends Frequency.FrequencyBuilderImpl implements CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder {
	
		protected Boolean balanceOfFirstPeriod;
		
		@Override
		@RosettaAttribute("balanceOfFirstPeriod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("balanceOfFirstPeriod")
		public Boolean getBalanceOfFirstPeriod() {
			return balanceOfFirstPeriod;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("periodMultiplier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("periodMultiplier")
		@Override
		public CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder setPeriodMultiplier(Integer _periodMultiplier) {
			this.periodMultiplier = _periodMultiplier == null ? null : _periodMultiplier;
			return this;
		}
		
		@RosettaAttribute("period")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("period")
		@Override
		public CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder setPeriod(PeriodExtendedEnum _period) {
			this.period = _period == null ? null : _period;
			return this;
		}
		
		@RosettaAttribute("balanceOfFirstPeriod")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("balanceOfFirstPeriod")
		@Override
		public CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder setBalanceOfFirstPeriod(Boolean _balanceOfFirstPeriod) {
			this.balanceOfFirstPeriod = _balanceOfFirstPeriod == null ? null : _balanceOfFirstPeriod;
			return this;
		}
		
		@Override
		public CommodityCalculationPeriodsSchedule build() {
			return new CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleImpl(this);
		}
		
		@Override
		public CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getBalanceOfFirstPeriod()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder o = (CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder) other;
			
			
			merger.mergeBasic(getBalanceOfFirstPeriod(), o.getBalanceOfFirstPeriod(), this::setBalanceOfFirstPeriod);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CommodityCalculationPeriodsSchedule _that = getType().cast(o);
		
			if (!Objects.equals(balanceOfFirstPeriod, _that.getBalanceOfFirstPeriod())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (balanceOfFirstPeriod != null ? balanceOfFirstPeriod.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityCalculationPeriodsScheduleBuilder {" +
				"balanceOfFirstPeriod=" + this.balanceOfFirstPeriod +
			'}' + " " + super.toString();
		}
	}
}
