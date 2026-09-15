package fpml.consolidated.shared;

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
import fpml.consolidated.shared.meta.FallbackRateObservationMeta;
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
 * Provision A type defining parameters associated with a fallback observation, i.e. a rate observation where the original published rate is not available and instead a fallback rate must be used.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type defining parameters associated with a fallback observation, i.e. a rate observation where the original published rate is not available and instead a fallback rate must be used.
 *
 */
@RosettaDataType(value="FallbackRateObservation", builder=FallbackRateObservation.FallbackRateObservationBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FallbackRateObservation", model="fpml", builder=FallbackRateObservation.FallbackRateObservationBuilderImpl.class, version="2.1.1")
public interface FallbackRateObservation extends RosettaModelObject {

	FallbackRateObservationMeta metaData = new FallbackRateObservationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The date which is the Fallback Observation Date, as defined in the ISDA 2006/2021 Definitions (typically 2 days prior to the relevant Payment/calculation date.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The date which is the Fallback Observation Date, as defined in the ISDA 2006/2021 Definitions (typically 2 days prior to the relevant Payment/calculation date.
	 *
	 */
	ZonedDateTime getObservationDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The original record date from the fallback publication source that was available at the time that fallback rate was observed. This may be before the original fixing date depending on publication schedules
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The original record date from the fallback publication source that was available at the time that fallback rate was observed. This may be before the original fixing date depending on publication schedules
	 *
	 */
	ZonedDateTime getAvailableRecordDate();

	/*********************** Build Methods  ***********************/
	FallbackRateObservation build();
	
	FallbackRateObservation.FallbackRateObservationBuilder toBuilder();
	
	static FallbackRateObservation.FallbackRateObservationBuilder builder() {
		return new FallbackRateObservation.FallbackRateObservationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FallbackRateObservation> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FallbackRateObservation> getType() {
		return FallbackRateObservation.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("observationDate"), ZonedDateTime.class, getObservationDate(), this);
		processor.processBasic(path.newSubPath("availableRecordDate"), ZonedDateTime.class, getAvailableRecordDate(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FallbackRateObservationBuilder extends FallbackRateObservation, RosettaModelObjectBuilder {
		FallbackRateObservation.FallbackRateObservationBuilder setObservationDate(ZonedDateTime observationDate);
		FallbackRateObservation.FallbackRateObservationBuilder setAvailableRecordDate(ZonedDateTime availableRecordDate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("observationDate"), ZonedDateTime.class, getObservationDate(), this);
			processor.processBasic(path.newSubPath("availableRecordDate"), ZonedDateTime.class, getAvailableRecordDate(), this);
		}
		

		FallbackRateObservation.FallbackRateObservationBuilder prune();
	}

	/*********************** Immutable Implementation of FallbackRateObservation  ***********************/
	class FallbackRateObservationImpl implements FallbackRateObservation {
		private final ZonedDateTime observationDate;
		private final ZonedDateTime availableRecordDate;
		
		protected FallbackRateObservationImpl(FallbackRateObservation.FallbackRateObservationBuilder builder) {
			this.observationDate = builder.getObservationDate();
			this.availableRecordDate = builder.getAvailableRecordDate();
		}
		
		@Override
		@RosettaAttribute("observationDate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("observationDate")
		public ZonedDateTime getObservationDate() {
			return observationDate;
		}
		
		@Override
		@RosettaAttribute("availableRecordDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("availableRecordDate")
		public ZonedDateTime getAvailableRecordDate() {
			return availableRecordDate;
		}
		
		@Override
		public FallbackRateObservation build() {
			return this;
		}
		
		@Override
		public FallbackRateObservation.FallbackRateObservationBuilder toBuilder() {
			FallbackRateObservation.FallbackRateObservationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FallbackRateObservation.FallbackRateObservationBuilder builder) {
			ofNullable(getObservationDate()).ifPresent(builder::setObservationDate);
			ofNullable(getAvailableRecordDate()).ifPresent(builder::setAvailableRecordDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FallbackRateObservation _that = getType().cast(o);
		
			if (!Objects.equals(observationDate, _that.getObservationDate())) return false;
			if (!Objects.equals(availableRecordDate, _that.getAvailableRecordDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (observationDate != null ? observationDate.hashCode() : 0);
			_result = 31 * _result + (availableRecordDate != null ? availableRecordDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FallbackRateObservation {" +
				"observationDate=" + this.observationDate + ", " +
				"availableRecordDate=" + this.availableRecordDate +
			'}';
		}
	}

	/*********************** Builder Implementation of FallbackRateObservation  ***********************/
	class FallbackRateObservationBuilderImpl implements FallbackRateObservation.FallbackRateObservationBuilder {
	
		protected ZonedDateTime observationDate;
		protected ZonedDateTime availableRecordDate;
		
		@Override
		@RosettaAttribute("observationDate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("observationDate")
		public ZonedDateTime getObservationDate() {
			return observationDate;
		}
		
		@Override
		@RosettaAttribute("availableRecordDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("availableRecordDate")
		public ZonedDateTime getAvailableRecordDate() {
			return availableRecordDate;
		}
		
		@RosettaAttribute("observationDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("observationDate")
		@Override
		public FallbackRateObservation.FallbackRateObservationBuilder setObservationDate(ZonedDateTime _observationDate) {
			this.observationDate = _observationDate == null ? null : _observationDate;
			return this;
		}
		
		@RosettaAttribute("availableRecordDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("availableRecordDate")
		@Override
		public FallbackRateObservation.FallbackRateObservationBuilder setAvailableRecordDate(ZonedDateTime _availableRecordDate) {
			this.availableRecordDate = _availableRecordDate == null ? null : _availableRecordDate;
			return this;
		}
		
		@Override
		public FallbackRateObservation build() {
			return new FallbackRateObservation.FallbackRateObservationImpl(this);
		}
		
		@Override
		public FallbackRateObservation.FallbackRateObservationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FallbackRateObservation.FallbackRateObservationBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getObservationDate()!=null) return true;
			if (getAvailableRecordDate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FallbackRateObservation.FallbackRateObservationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FallbackRateObservation.FallbackRateObservationBuilder o = (FallbackRateObservation.FallbackRateObservationBuilder) other;
			
			
			merger.mergeBasic(getObservationDate(), o.getObservationDate(), this::setObservationDate);
			merger.mergeBasic(getAvailableRecordDate(), o.getAvailableRecordDate(), this::setAvailableRecordDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FallbackRateObservation _that = getType().cast(o);
		
			if (!Objects.equals(observationDate, _that.getObservationDate())) return false;
			if (!Objects.equals(availableRecordDate, _that.getAvailableRecordDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (observationDate != null ? observationDate.hashCode() : 0);
			_result = 31 * _result + (availableRecordDate != null ? availableRecordDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FallbackRateObservationBuilder {" +
				"observationDate=" + this.observationDate + ", " +
				"availableRecordDate=" + this.availableRecordDate +
			'}';
		}
	}
}
