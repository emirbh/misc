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
import fpml.consolidated.com.meta.EEPRiskPeriodMeta;
import java.time.ZonedDateTime;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision TBD.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision TBD.
 *
 */
@RosettaDataType(value="EEPRiskPeriod", builder=EEPRiskPeriod.EEPRiskPeriodBuilderImpl.class, version="2.1.1")
@RuneDataType(value="EEPRiskPeriod", model="fpml", builder=EEPRiskPeriod.EEPRiskPeriodBuilderImpl.class, version="2.1.1")
public interface EEPRiskPeriod extends RosettaModelObject {

	EEPRiskPeriodMeta metaData = new EEPRiskPeriodMeta();

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
	ZonedDateTime getStartDate();
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
	ZonedDateTime getEndDate();

	/*********************** Build Methods  ***********************/
	EEPRiskPeriod build();
	
	EEPRiskPeriod.EEPRiskPeriodBuilder toBuilder();
	
	static EEPRiskPeriod.EEPRiskPeriodBuilder builder() {
		return new EEPRiskPeriod.EEPRiskPeriodBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends EEPRiskPeriod> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends EEPRiskPeriod> getType() {
		return EEPRiskPeriod.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("startDate"), ZonedDateTime.class, getStartDate(), this);
		processor.processBasic(path.newSubPath("endDate"), ZonedDateTime.class, getEndDate(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface EEPRiskPeriodBuilder extends EEPRiskPeriod, RosettaModelObjectBuilder {
		EEPRiskPeriod.EEPRiskPeriodBuilder setStartDate(ZonedDateTime startDate);
		EEPRiskPeriod.EEPRiskPeriodBuilder setEndDate(ZonedDateTime endDate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("startDate"), ZonedDateTime.class, getStartDate(), this);
			processor.processBasic(path.newSubPath("endDate"), ZonedDateTime.class, getEndDate(), this);
		}
		

		EEPRiskPeriod.EEPRiskPeriodBuilder prune();
	}

	/*********************** Immutable Implementation of EEPRiskPeriod  ***********************/
	class EEPRiskPeriodImpl implements EEPRiskPeriod {
		private final ZonedDateTime startDate;
		private final ZonedDateTime endDate;
		
		protected EEPRiskPeriodImpl(EEPRiskPeriod.EEPRiskPeriodBuilder builder) {
			this.startDate = builder.getStartDate();
			this.endDate = builder.getEndDate();
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
		public EEPRiskPeriod build() {
			return this;
		}
		
		@Override
		public EEPRiskPeriod.EEPRiskPeriodBuilder toBuilder() {
			EEPRiskPeriod.EEPRiskPeriodBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EEPRiskPeriod.EEPRiskPeriodBuilder builder) {
			ofNullable(getStartDate()).ifPresent(builder::setStartDate);
			ofNullable(getEndDate()).ifPresent(builder::setEndDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EEPRiskPeriod _that = getType().cast(o);
		
			if (!Objects.equals(startDate, _that.getStartDate())) return false;
			if (!Objects.equals(endDate, _that.getEndDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (startDate != null ? startDate.hashCode() : 0);
			_result = 31 * _result + (endDate != null ? endDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EEPRiskPeriod {" +
				"startDate=" + this.startDate + ", " +
				"endDate=" + this.endDate +
			'}';
		}
	}

	/*********************** Builder Implementation of EEPRiskPeriod  ***********************/
	class EEPRiskPeriodBuilderImpl implements EEPRiskPeriod.EEPRiskPeriodBuilder {
	
		protected ZonedDateTime startDate;
		protected ZonedDateTime endDate;
		
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
		
		@RosettaAttribute("startDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("startDate")
		@Override
		public EEPRiskPeriod.EEPRiskPeriodBuilder setStartDate(ZonedDateTime _startDate) {
			this.startDate = _startDate == null ? null : _startDate;
			return this;
		}
		
		@RosettaAttribute("endDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("endDate")
		@Override
		public EEPRiskPeriod.EEPRiskPeriodBuilder setEndDate(ZonedDateTime _endDate) {
			this.endDate = _endDate == null ? null : _endDate;
			return this;
		}
		
		@Override
		public EEPRiskPeriod build() {
			return new EEPRiskPeriod.EEPRiskPeriodImpl(this);
		}
		
		@Override
		public EEPRiskPeriod.EEPRiskPeriodBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EEPRiskPeriod.EEPRiskPeriodBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getStartDate()!=null) return true;
			if (getEndDate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EEPRiskPeriod.EEPRiskPeriodBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			EEPRiskPeriod.EEPRiskPeriodBuilder o = (EEPRiskPeriod.EEPRiskPeriodBuilder) other;
			
			
			merger.mergeBasic(getStartDate(), o.getStartDate(), this::setStartDate);
			merger.mergeBasic(getEndDate(), o.getEndDate(), this::setEndDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EEPRiskPeriod _that = getType().cast(o);
		
			if (!Objects.equals(startDate, _that.getStartDate())) return false;
			if (!Objects.equals(endDate, _that.getEndDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (startDate != null ? startDate.hashCode() : 0);
			_result = 31 * _result + (endDate != null ? endDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EEPRiskPeriodBuilder {" +
				"startDate=" + this.startDate + ", " +
				"endDate=" + this.endDate +
			'}';
		}
	}
}
