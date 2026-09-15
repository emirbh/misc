package fpml.consolidated.fx.targets;

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
import fpml.consolidated.fx.targets.meta.SettlementPeriodFixingDatesMeta;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
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
@RosettaDataType(value="SettlementPeriodFixingDates", builder=SettlementPeriodFixingDates.SettlementPeriodFixingDatesBuilderImpl.class, version="2.1.1")
@RuneDataType(value="SettlementPeriodFixingDates", model="fpml", builder=SettlementPeriodFixingDates.SettlementPeriodFixingDatesBuilderImpl.class, version="2.1.1")
public interface SettlementPeriodFixingDates extends RosettaModelObject {

	SettlementPeriodFixingDatesMeta metaData = new SettlementPeriodFixingDatesMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Observation date in a fixing period.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Observation date in a fixing period.
	 *
	 */
	List<ZonedDateTime> getFixingDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Start date of the period.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Start date of the period.
	 *
	 */
	ZonedDateTime getStartDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision End date of the period.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision End date of the period.
	 *
	 */
	ZonedDateTime getEndDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Number of fixings between the fixing start and end date.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Number of fixings between the fixing start and end date.
	 *
	 */
	Integer getNumberOfFixings();

	/*********************** Build Methods  ***********************/
	SettlementPeriodFixingDates build();
	
	SettlementPeriodFixingDates.SettlementPeriodFixingDatesBuilder toBuilder();
	
	static SettlementPeriodFixingDates.SettlementPeriodFixingDatesBuilder builder() {
		return new SettlementPeriodFixingDates.SettlementPeriodFixingDatesBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SettlementPeriodFixingDates> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends SettlementPeriodFixingDates> getType() {
		return SettlementPeriodFixingDates.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("fixingDate"), ZonedDateTime.class, getFixingDate(), this);
		processor.processBasic(path.newSubPath("startDate"), ZonedDateTime.class, getStartDate(), this);
		processor.processBasic(path.newSubPath("endDate"), ZonedDateTime.class, getEndDate(), this);
		processor.processBasic(path.newSubPath("numberOfFixings"), Integer.class, getNumberOfFixings(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface SettlementPeriodFixingDatesBuilder extends SettlementPeriodFixingDates, RosettaModelObjectBuilder {
		SettlementPeriodFixingDates.SettlementPeriodFixingDatesBuilder addFixingDate(ZonedDateTime fixingDate);
		SettlementPeriodFixingDates.SettlementPeriodFixingDatesBuilder addFixingDate(ZonedDateTime fixingDate, int idx);
		SettlementPeriodFixingDates.SettlementPeriodFixingDatesBuilder addFixingDate(List<ZonedDateTime> fixingDate);
		SettlementPeriodFixingDates.SettlementPeriodFixingDatesBuilder setFixingDate(List<ZonedDateTime> fixingDate);
		SettlementPeriodFixingDates.SettlementPeriodFixingDatesBuilder setStartDate(ZonedDateTime startDate);
		SettlementPeriodFixingDates.SettlementPeriodFixingDatesBuilder setEndDate(ZonedDateTime endDate);
		SettlementPeriodFixingDates.SettlementPeriodFixingDatesBuilder setNumberOfFixings(Integer numberOfFixings);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("fixingDate"), ZonedDateTime.class, getFixingDate(), this);
			processor.processBasic(path.newSubPath("startDate"), ZonedDateTime.class, getStartDate(), this);
			processor.processBasic(path.newSubPath("endDate"), ZonedDateTime.class, getEndDate(), this);
			processor.processBasic(path.newSubPath("numberOfFixings"), Integer.class, getNumberOfFixings(), this);
		}
		

		SettlementPeriodFixingDates.SettlementPeriodFixingDatesBuilder prune();
	}

	/*********************** Immutable Implementation of SettlementPeriodFixingDates  ***********************/
	class SettlementPeriodFixingDatesImpl implements SettlementPeriodFixingDates {
		private final List<ZonedDateTime> fixingDate;
		private final ZonedDateTime startDate;
		private final ZonedDateTime endDate;
		private final Integer numberOfFixings;
		
		protected SettlementPeriodFixingDatesImpl(SettlementPeriodFixingDates.SettlementPeriodFixingDatesBuilder builder) {
			this.fixingDate = ofNullable(builder.getFixingDate()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.startDate = builder.getStartDate();
			this.endDate = builder.getEndDate();
			this.numberOfFixings = builder.getNumberOfFixings();
		}
		
		@Override
		@RosettaAttribute("fixingDate")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("fixingDate")
		public List<ZonedDateTime> getFixingDate() {
			return fixingDate;
		}
		
		@Override
		@RosettaAttribute("startDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("startDate")
		public ZonedDateTime getStartDate() {
			return startDate;
		}
		
		@Override
		@RosettaAttribute("endDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("endDate")
		public ZonedDateTime getEndDate() {
			return endDate;
		}
		
		@Override
		@RosettaAttribute("numberOfFixings")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("numberOfFixings")
		public Integer getNumberOfFixings() {
			return numberOfFixings;
		}
		
		@Override
		public SettlementPeriodFixingDates build() {
			return this;
		}
		
		@Override
		public SettlementPeriodFixingDates.SettlementPeriodFixingDatesBuilder toBuilder() {
			SettlementPeriodFixingDates.SettlementPeriodFixingDatesBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SettlementPeriodFixingDates.SettlementPeriodFixingDatesBuilder builder) {
			ofNullable(getFixingDate()).ifPresent(builder::setFixingDate);
			ofNullable(getStartDate()).ifPresent(builder::setStartDate);
			ofNullable(getEndDate()).ifPresent(builder::setEndDate);
			ofNullable(getNumberOfFixings()).ifPresent(builder::setNumberOfFixings);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SettlementPeriodFixingDates _that = getType().cast(o);
		
			if (!ListEquals.listEquals(fixingDate, _that.getFixingDate())) return false;
			if (!Objects.equals(startDate, _that.getStartDate())) return false;
			if (!Objects.equals(endDate, _that.getEndDate())) return false;
			if (!Objects.equals(numberOfFixings, _that.getNumberOfFixings())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (fixingDate != null ? fixingDate.hashCode() : 0);
			_result = 31 * _result + (startDate != null ? startDate.hashCode() : 0);
			_result = 31 * _result + (endDate != null ? endDate.hashCode() : 0);
			_result = 31 * _result + (numberOfFixings != null ? numberOfFixings.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SettlementPeriodFixingDates {" +
				"fixingDate=" + this.fixingDate + ", " +
				"startDate=" + this.startDate + ", " +
				"endDate=" + this.endDate + ", " +
				"numberOfFixings=" + this.numberOfFixings +
			'}';
		}
	}

	/*********************** Builder Implementation of SettlementPeriodFixingDates  ***********************/
	class SettlementPeriodFixingDatesBuilderImpl implements SettlementPeriodFixingDates.SettlementPeriodFixingDatesBuilder {
	
		protected List<ZonedDateTime> fixingDate = new ArrayList<>();
		protected ZonedDateTime startDate;
		protected ZonedDateTime endDate;
		protected Integer numberOfFixings;
		
		@Override
		@RosettaAttribute("fixingDate")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("fixingDate")
		public List<ZonedDateTime> getFixingDate() {
			return fixingDate;
		}
		
		@Override
		@RosettaAttribute("startDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("startDate")
		public ZonedDateTime getStartDate() {
			return startDate;
		}
		
		@Override
		@RosettaAttribute("endDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("endDate")
		public ZonedDateTime getEndDate() {
			return endDate;
		}
		
		@Override
		@RosettaAttribute("numberOfFixings")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("numberOfFixings")
		public Integer getNumberOfFixings() {
			return numberOfFixings;
		}
		
		@RosettaAttribute("fixingDate")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("fixingDate")
		@Override
		public SettlementPeriodFixingDates.SettlementPeriodFixingDatesBuilder addFixingDate(ZonedDateTime _fixingDate) {
			if (_fixingDate != null) {
				this.fixingDate.add(_fixingDate);
			}
			return this;
		}
		
		@Override
		public SettlementPeriodFixingDates.SettlementPeriodFixingDatesBuilder addFixingDate(ZonedDateTime _fixingDate, int idx) {
			getIndex(this.fixingDate, idx, () -> _fixingDate);
			return this;
		}
		
		@Override
		public SettlementPeriodFixingDates.SettlementPeriodFixingDatesBuilder addFixingDate(List<ZonedDateTime> fixingDates) {
			if (fixingDates != null) {
				for (final ZonedDateTime toAdd : fixingDates) {
					this.fixingDate.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("fixingDate")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("fixingDate")
		@Override
		public SettlementPeriodFixingDates.SettlementPeriodFixingDatesBuilder setFixingDate(List<ZonedDateTime> fixingDates) {
			if (fixingDates == null) {
				this.fixingDate = new ArrayList<>();
			} else {
				this.fixingDate = fixingDates.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("startDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("startDate")
		@Override
		public SettlementPeriodFixingDates.SettlementPeriodFixingDatesBuilder setStartDate(ZonedDateTime _startDate) {
			this.startDate = _startDate == null ? null : _startDate;
			return this;
		}
		
		@RosettaAttribute("endDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("endDate")
		@Override
		public SettlementPeriodFixingDates.SettlementPeriodFixingDatesBuilder setEndDate(ZonedDateTime _endDate) {
			this.endDate = _endDate == null ? null : _endDate;
			return this;
		}
		
		@RosettaAttribute("numberOfFixings")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("numberOfFixings")
		@Override
		public SettlementPeriodFixingDates.SettlementPeriodFixingDatesBuilder setNumberOfFixings(Integer _numberOfFixings) {
			this.numberOfFixings = _numberOfFixings == null ? null : _numberOfFixings;
			return this;
		}
		
		@Override
		public SettlementPeriodFixingDates build() {
			return new SettlementPeriodFixingDates.SettlementPeriodFixingDatesImpl(this);
		}
		
		@Override
		public SettlementPeriodFixingDates.SettlementPeriodFixingDatesBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SettlementPeriodFixingDates.SettlementPeriodFixingDatesBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getFixingDate()!=null && !getFixingDate().isEmpty()) return true;
			if (getStartDate()!=null) return true;
			if (getEndDate()!=null) return true;
			if (getNumberOfFixings()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SettlementPeriodFixingDates.SettlementPeriodFixingDatesBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SettlementPeriodFixingDates.SettlementPeriodFixingDatesBuilder o = (SettlementPeriodFixingDates.SettlementPeriodFixingDatesBuilder) other;
			
			
			merger.mergeBasic(getFixingDate(), o.getFixingDate(), (Consumer<ZonedDateTime>) this::addFixingDate);
			merger.mergeBasic(getStartDate(), o.getStartDate(), this::setStartDate);
			merger.mergeBasic(getEndDate(), o.getEndDate(), this::setEndDate);
			merger.mergeBasic(getNumberOfFixings(), o.getNumberOfFixings(), this::setNumberOfFixings);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SettlementPeriodFixingDates _that = getType().cast(o);
		
			if (!ListEquals.listEquals(fixingDate, _that.getFixingDate())) return false;
			if (!Objects.equals(startDate, _that.getStartDate())) return false;
			if (!Objects.equals(endDate, _that.getEndDate())) return false;
			if (!Objects.equals(numberOfFixings, _that.getNumberOfFixings())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (fixingDate != null ? fixingDate.hashCode() : 0);
			_result = 31 * _result + (startDate != null ? startDate.hashCode() : 0);
			_result = 31 * _result + (endDate != null ? endDate.hashCode() : 0);
			_result = 31 * _result + (numberOfFixings != null ? numberOfFixings.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SettlementPeriodFixingDatesBuilder {" +
				"fixingDate=" + this.fixingDate + ", " +
				"startDate=" + this.startDate + ", " +
				"endDate=" + this.endDate + ", " +
				"numberOfFixings=" + this.numberOfFixings +
			'}';
		}
	}
}
