package fpml.consolidated.loan;

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
import fpml.consolidated.loan.meta.LoanAllocationNoSettlePeriodMeta;
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
 * Provision A structure that describes a period during which settlement cannot occur.
 *
 */
@RosettaDataType(value="LoanAllocationNoSettlePeriod", builder=LoanAllocationNoSettlePeriod.LoanAllocationNoSettlePeriodBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LoanAllocationNoSettlePeriod", model="fpml", builder=LoanAllocationNoSettlePeriod.LoanAllocationNoSettlePeriodBuilderImpl.class, version="2.1.1")
public interface LoanAllocationNoSettlePeriod extends RosettaModelObject {

	LoanAllocationNoSettlePeriodMeta metaData = new LoanAllocationNoSettlePeriodMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Date on which this period begins.
	 *
	 */
	ZonedDateTime getStartDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Date on which this period ends.
	 *
	 */
	ZonedDateTime getEndDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A list of allowable types of no-settle periods.
	 *
	 */
	LoanAllocationNoSettlePeriodType getPeriodType();

	/*********************** Build Methods  ***********************/
	LoanAllocationNoSettlePeriod build();
	
	LoanAllocationNoSettlePeriod.LoanAllocationNoSettlePeriodBuilder toBuilder();
	
	static LoanAllocationNoSettlePeriod.LoanAllocationNoSettlePeriodBuilder builder() {
		return new LoanAllocationNoSettlePeriod.LoanAllocationNoSettlePeriodBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanAllocationNoSettlePeriod> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LoanAllocationNoSettlePeriod> getType() {
		return LoanAllocationNoSettlePeriod.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("startDate"), ZonedDateTime.class, getStartDate(), this);
		processor.processBasic(path.newSubPath("endDate"), ZonedDateTime.class, getEndDate(), this);
		processRosetta(path.newSubPath("periodType"), processor, LoanAllocationNoSettlePeriodType.class, getPeriodType());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanAllocationNoSettlePeriodBuilder extends LoanAllocationNoSettlePeriod, RosettaModelObjectBuilder {
		LoanAllocationNoSettlePeriodType.LoanAllocationNoSettlePeriodTypeBuilder getOrCreatePeriodType();
		@Override
		LoanAllocationNoSettlePeriodType.LoanAllocationNoSettlePeriodTypeBuilder getPeriodType();
		LoanAllocationNoSettlePeriod.LoanAllocationNoSettlePeriodBuilder setStartDate(ZonedDateTime startDate);
		LoanAllocationNoSettlePeriod.LoanAllocationNoSettlePeriodBuilder setEndDate(ZonedDateTime endDate);
		LoanAllocationNoSettlePeriod.LoanAllocationNoSettlePeriodBuilder setPeriodType(LoanAllocationNoSettlePeriodType periodType);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("startDate"), ZonedDateTime.class, getStartDate(), this);
			processor.processBasic(path.newSubPath("endDate"), ZonedDateTime.class, getEndDate(), this);
			processRosetta(path.newSubPath("periodType"), processor, LoanAllocationNoSettlePeriodType.LoanAllocationNoSettlePeriodTypeBuilder.class, getPeriodType());
		}
		

		LoanAllocationNoSettlePeriod.LoanAllocationNoSettlePeriodBuilder prune();
	}

	/*********************** Immutable Implementation of LoanAllocationNoSettlePeriod  ***********************/
	class LoanAllocationNoSettlePeriodImpl implements LoanAllocationNoSettlePeriod {
		private final ZonedDateTime startDate;
		private final ZonedDateTime endDate;
		private final LoanAllocationNoSettlePeriodType periodType;
		
		protected LoanAllocationNoSettlePeriodImpl(LoanAllocationNoSettlePeriod.LoanAllocationNoSettlePeriodBuilder builder) {
			this.startDate = builder.getStartDate();
			this.endDate = builder.getEndDate();
			this.periodType = ofNullable(builder.getPeriodType()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("startDate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("startDate")
		public ZonedDateTime getStartDate() {
			return startDate;
		}
		
		@Override
		@RosettaAttribute("endDate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("endDate")
		public ZonedDateTime getEndDate() {
			return endDate;
		}
		
		@Override
		@RosettaAttribute("periodType")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("periodType")
		public LoanAllocationNoSettlePeriodType getPeriodType() {
			return periodType;
		}
		
		@Override
		public LoanAllocationNoSettlePeriod build() {
			return this;
		}
		
		@Override
		public LoanAllocationNoSettlePeriod.LoanAllocationNoSettlePeriodBuilder toBuilder() {
			LoanAllocationNoSettlePeriod.LoanAllocationNoSettlePeriodBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanAllocationNoSettlePeriod.LoanAllocationNoSettlePeriodBuilder builder) {
			ofNullable(getStartDate()).ifPresent(builder::setStartDate);
			ofNullable(getEndDate()).ifPresent(builder::setEndDate);
			ofNullable(getPeriodType()).ifPresent(builder::setPeriodType);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanAllocationNoSettlePeriod _that = getType().cast(o);
		
			if (!Objects.equals(startDate, _that.getStartDate())) return false;
			if (!Objects.equals(endDate, _that.getEndDate())) return false;
			if (!Objects.equals(periodType, _that.getPeriodType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (startDate != null ? startDate.hashCode() : 0);
			_result = 31 * _result + (endDate != null ? endDate.hashCode() : 0);
			_result = 31 * _result + (periodType != null ? periodType.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanAllocationNoSettlePeriod {" +
				"startDate=" + this.startDate + ", " +
				"endDate=" + this.endDate + ", " +
				"periodType=" + this.periodType +
			'}';
		}
	}

	/*********************** Builder Implementation of LoanAllocationNoSettlePeriod  ***********************/
	class LoanAllocationNoSettlePeriodBuilderImpl implements LoanAllocationNoSettlePeriod.LoanAllocationNoSettlePeriodBuilder {
	
		protected ZonedDateTime startDate;
		protected ZonedDateTime endDate;
		protected LoanAllocationNoSettlePeriodType.LoanAllocationNoSettlePeriodTypeBuilder periodType;
		
		@Override
		@RosettaAttribute("startDate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("startDate")
		public ZonedDateTime getStartDate() {
			return startDate;
		}
		
		@Override
		@RosettaAttribute("endDate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("endDate")
		public ZonedDateTime getEndDate() {
			return endDate;
		}
		
		@Override
		@RosettaAttribute("periodType")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("periodType")
		public LoanAllocationNoSettlePeriodType.LoanAllocationNoSettlePeriodTypeBuilder getPeriodType() {
			return periodType;
		}
		
		@Override
		public LoanAllocationNoSettlePeriodType.LoanAllocationNoSettlePeriodTypeBuilder getOrCreatePeriodType() {
			LoanAllocationNoSettlePeriodType.LoanAllocationNoSettlePeriodTypeBuilder result;
			if (periodType!=null) {
				result = periodType;
			}
			else {
				result = periodType = LoanAllocationNoSettlePeriodType.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("startDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("startDate")
		@Override
		public LoanAllocationNoSettlePeriod.LoanAllocationNoSettlePeriodBuilder setStartDate(ZonedDateTime _startDate) {
			this.startDate = _startDate == null ? null : _startDate;
			return this;
		}
		
		@RosettaAttribute("endDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("endDate")
		@Override
		public LoanAllocationNoSettlePeriod.LoanAllocationNoSettlePeriodBuilder setEndDate(ZonedDateTime _endDate) {
			this.endDate = _endDate == null ? null : _endDate;
			return this;
		}
		
		@RosettaAttribute("periodType")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("periodType")
		@Override
		public LoanAllocationNoSettlePeriod.LoanAllocationNoSettlePeriodBuilder setPeriodType(LoanAllocationNoSettlePeriodType _periodType) {
			this.periodType = _periodType == null ? null : _periodType.toBuilder();
			return this;
		}
		
		@Override
		public LoanAllocationNoSettlePeriod build() {
			return new LoanAllocationNoSettlePeriod.LoanAllocationNoSettlePeriodImpl(this);
		}
		
		@Override
		public LoanAllocationNoSettlePeriod.LoanAllocationNoSettlePeriodBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanAllocationNoSettlePeriod.LoanAllocationNoSettlePeriodBuilder prune() {
			if (periodType!=null && !periodType.prune().hasData()) periodType = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getStartDate()!=null) return true;
			if (getEndDate()!=null) return true;
			if (getPeriodType()!=null && getPeriodType().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanAllocationNoSettlePeriod.LoanAllocationNoSettlePeriodBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LoanAllocationNoSettlePeriod.LoanAllocationNoSettlePeriodBuilder o = (LoanAllocationNoSettlePeriod.LoanAllocationNoSettlePeriodBuilder) other;
			
			merger.mergeRosetta(getPeriodType(), o.getPeriodType(), this::setPeriodType);
			
			merger.mergeBasic(getStartDate(), o.getStartDate(), this::setStartDate);
			merger.mergeBasic(getEndDate(), o.getEndDate(), this::setEndDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanAllocationNoSettlePeriod _that = getType().cast(o);
		
			if (!Objects.equals(startDate, _that.getStartDate())) return false;
			if (!Objects.equals(endDate, _that.getEndDate())) return false;
			if (!Objects.equals(periodType, _that.getPeriodType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (startDate != null ? startDate.hashCode() : 0);
			_result = 31 * _result + (endDate != null ? endDate.hashCode() : 0);
			_result = 31 * _result + (periodType != null ? periodType.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanAllocationNoSettlePeriodBuilder {" +
				"startDate=" + this.startDate + ", " +
				"endDate=" + this.endDate + ", " +
				"periodType=" + this.periodType +
			'}';
		}
	}
}
