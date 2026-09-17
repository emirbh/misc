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
import fpml.consolidated.loan.meta.UtilizationPeriodMeta;
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
 * Provision A schedule that incorporates all sub-periods of an interest accrual calculation.
 *
 */
@RosettaDataType(value="UtilizationPeriod", builder=UtilizationPeriod.UtilizationPeriodBuilderImpl.class, version="2.1.1")
@RuneDataType(value="UtilizationPeriod", model="fpml", builder=UtilizationPeriod.UtilizationPeriodBuilderImpl.class, version="2.1.1")
public interface UtilizationPeriod extends RosettaModelObject {

	UtilizationPeriodMeta metaData = new UtilizationPeriodMeta();

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
	 * Provision The actual number of days represented within the 'period'. This takes into account counting the appropriate convention.
	 *
	 */
	Integer getNumberOfDays();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The funded and unfunded utilization details.
	 *
	 */
	UtilizationAmounts getUtilizationAmounts();

	/*********************** Build Methods  ***********************/
	UtilizationPeriod build();
	
	UtilizationPeriod.UtilizationPeriodBuilder toBuilder();
	
	static UtilizationPeriod.UtilizationPeriodBuilder builder() {
		return new UtilizationPeriod.UtilizationPeriodBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends UtilizationPeriod> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends UtilizationPeriod> getType() {
		return UtilizationPeriod.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("startDate"), ZonedDateTime.class, getStartDate(), this);
		processor.processBasic(path.newSubPath("endDate"), ZonedDateTime.class, getEndDate(), this);
		processor.processBasic(path.newSubPath("numberOfDays"), Integer.class, getNumberOfDays(), this);
		processRosetta(path.newSubPath("utilizationAmounts"), processor, UtilizationAmounts.class, getUtilizationAmounts());
	}
	

	/*********************** Builder Interface  ***********************/
	interface UtilizationPeriodBuilder extends UtilizationPeriod, RosettaModelObjectBuilder {
		UtilizationAmounts.UtilizationAmountsBuilder getOrCreateUtilizationAmounts();
		@Override
		UtilizationAmounts.UtilizationAmountsBuilder getUtilizationAmounts();
		UtilizationPeriod.UtilizationPeriodBuilder setStartDate(ZonedDateTime startDate);
		UtilizationPeriod.UtilizationPeriodBuilder setEndDate(ZonedDateTime endDate);
		UtilizationPeriod.UtilizationPeriodBuilder setNumberOfDays(Integer numberOfDays);
		UtilizationPeriod.UtilizationPeriodBuilder setUtilizationAmounts(UtilizationAmounts utilizationAmounts);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("startDate"), ZonedDateTime.class, getStartDate(), this);
			processor.processBasic(path.newSubPath("endDate"), ZonedDateTime.class, getEndDate(), this);
			processor.processBasic(path.newSubPath("numberOfDays"), Integer.class, getNumberOfDays(), this);
			processRosetta(path.newSubPath("utilizationAmounts"), processor, UtilizationAmounts.UtilizationAmountsBuilder.class, getUtilizationAmounts());
		}
		

		UtilizationPeriod.UtilizationPeriodBuilder prune();
	}

	/*********************** Immutable Implementation of UtilizationPeriod  ***********************/
	class UtilizationPeriodImpl implements UtilizationPeriod {
		private final ZonedDateTime startDate;
		private final ZonedDateTime endDate;
		private final Integer numberOfDays;
		private final UtilizationAmounts utilizationAmounts;
		
		protected UtilizationPeriodImpl(UtilizationPeriod.UtilizationPeriodBuilder builder) {
			this.startDate = builder.getStartDate();
			this.endDate = builder.getEndDate();
			this.numberOfDays = builder.getNumberOfDays();
			this.utilizationAmounts = ofNullable(builder.getUtilizationAmounts()).map(f->f.build()).orElse(null);
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
		@RosettaAttribute("numberOfDays")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("numberOfDays")
		public Integer getNumberOfDays() {
			return numberOfDays;
		}
		
		@Override
		@RosettaAttribute("utilizationAmounts")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("utilizationAmounts")
		public UtilizationAmounts getUtilizationAmounts() {
			return utilizationAmounts;
		}
		
		@Override
		public UtilizationPeriod build() {
			return this;
		}
		
		@Override
		public UtilizationPeriod.UtilizationPeriodBuilder toBuilder() {
			UtilizationPeriod.UtilizationPeriodBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(UtilizationPeriod.UtilizationPeriodBuilder builder) {
			ofNullable(getStartDate()).ifPresent(builder::setStartDate);
			ofNullable(getEndDate()).ifPresent(builder::setEndDate);
			ofNullable(getNumberOfDays()).ifPresent(builder::setNumberOfDays);
			ofNullable(getUtilizationAmounts()).ifPresent(builder::setUtilizationAmounts);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			UtilizationPeriod _that = getType().cast(o);
		
			if (!Objects.equals(startDate, _that.getStartDate())) return false;
			if (!Objects.equals(endDate, _that.getEndDate())) return false;
			if (!Objects.equals(numberOfDays, _that.getNumberOfDays())) return false;
			if (!Objects.equals(utilizationAmounts, _that.getUtilizationAmounts())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (startDate != null ? startDate.hashCode() : 0);
			_result = 31 * _result + (endDate != null ? endDate.hashCode() : 0);
			_result = 31 * _result + (numberOfDays != null ? numberOfDays.hashCode() : 0);
			_result = 31 * _result + (utilizationAmounts != null ? utilizationAmounts.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "UtilizationPeriod {" +
				"startDate=" + this.startDate + ", " +
				"endDate=" + this.endDate + ", " +
				"numberOfDays=" + this.numberOfDays + ", " +
				"utilizationAmounts=" + this.utilizationAmounts +
			'}';
		}
	}

	/*********************** Builder Implementation of UtilizationPeriod  ***********************/
	class UtilizationPeriodBuilderImpl implements UtilizationPeriod.UtilizationPeriodBuilder {
	
		protected ZonedDateTime startDate;
		protected ZonedDateTime endDate;
		protected Integer numberOfDays;
		protected UtilizationAmounts.UtilizationAmountsBuilder utilizationAmounts;
		
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
		@RosettaAttribute("numberOfDays")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("numberOfDays")
		public Integer getNumberOfDays() {
			return numberOfDays;
		}
		
		@Override
		@RosettaAttribute("utilizationAmounts")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("utilizationAmounts")
		public UtilizationAmounts.UtilizationAmountsBuilder getUtilizationAmounts() {
			return utilizationAmounts;
		}
		
		@Override
		public UtilizationAmounts.UtilizationAmountsBuilder getOrCreateUtilizationAmounts() {
			UtilizationAmounts.UtilizationAmountsBuilder result;
			if (utilizationAmounts!=null) {
				result = utilizationAmounts;
			}
			else {
				result = utilizationAmounts = UtilizationAmounts.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("startDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("startDate")
		@Override
		public UtilizationPeriod.UtilizationPeriodBuilder setStartDate(ZonedDateTime _startDate) {
			this.startDate = _startDate == null ? null : _startDate;
			return this;
		}
		
		@RosettaAttribute("endDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("endDate")
		@Override
		public UtilizationPeriod.UtilizationPeriodBuilder setEndDate(ZonedDateTime _endDate) {
			this.endDate = _endDate == null ? null : _endDate;
			return this;
		}
		
		@RosettaAttribute("numberOfDays")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("numberOfDays")
		@Override
		public UtilizationPeriod.UtilizationPeriodBuilder setNumberOfDays(Integer _numberOfDays) {
			this.numberOfDays = _numberOfDays == null ? null : _numberOfDays;
			return this;
		}
		
		@RosettaAttribute("utilizationAmounts")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("utilizationAmounts")
		@Override
		public UtilizationPeriod.UtilizationPeriodBuilder setUtilizationAmounts(UtilizationAmounts _utilizationAmounts) {
			this.utilizationAmounts = _utilizationAmounts == null ? null : _utilizationAmounts.toBuilder();
			return this;
		}
		
		@Override
		public UtilizationPeriod build() {
			return new UtilizationPeriod.UtilizationPeriodImpl(this);
		}
		
		@Override
		public UtilizationPeriod.UtilizationPeriodBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public UtilizationPeriod.UtilizationPeriodBuilder prune() {
			if (utilizationAmounts!=null && !utilizationAmounts.prune().hasData()) utilizationAmounts = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getStartDate()!=null) return true;
			if (getEndDate()!=null) return true;
			if (getNumberOfDays()!=null) return true;
			if (getUtilizationAmounts()!=null && getUtilizationAmounts().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public UtilizationPeriod.UtilizationPeriodBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			UtilizationPeriod.UtilizationPeriodBuilder o = (UtilizationPeriod.UtilizationPeriodBuilder) other;
			
			merger.mergeRosetta(getUtilizationAmounts(), o.getUtilizationAmounts(), this::setUtilizationAmounts);
			
			merger.mergeBasic(getStartDate(), o.getStartDate(), this::setStartDate);
			merger.mergeBasic(getEndDate(), o.getEndDate(), this::setEndDate);
			merger.mergeBasic(getNumberOfDays(), o.getNumberOfDays(), this::setNumberOfDays);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			UtilizationPeriod _that = getType().cast(o);
		
			if (!Objects.equals(startDate, _that.getStartDate())) return false;
			if (!Objects.equals(endDate, _that.getEndDate())) return false;
			if (!Objects.equals(numberOfDays, _that.getNumberOfDays())) return false;
			if (!Objects.equals(utilizationAmounts, _that.getUtilizationAmounts())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (startDate != null ? startDate.hashCode() : 0);
			_result = 31 * _result + (endDate != null ? endDate.hashCode() : 0);
			_result = 31 * _result + (numberOfDays != null ? numberOfDays.hashCode() : 0);
			_result = 31 * _result + (utilizationAmounts != null ? utilizationAmounts.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "UtilizationPeriodBuilder {" +
				"startDate=" + this.startDate + ", " +
				"endDate=" + this.endDate + ", " +
				"numberOfDays=" + this.numberOfDays + ", " +
				"utilizationAmounts=" + this.utilizationAmounts +
			'}';
		}
	}
}
