package cdm.product.common.schedule;

import cdm.product.common.schedule.meta.ObservationDateMeta;
import com.rosetta.model.lib.GlobalKey;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.annotations.RuneMetaType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.metafields.MetaFields;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Specifies a single date on which market observations take place and specifies optional associated weighting.
 * @version 6.23.0
 */
@RosettaDataType(value="ObservationDate", builder=ObservationDate.ObservationDateBuilderImpl.class, version="6.23.0")
@RuneDataType(value="ObservationDate", model="cdm", builder=ObservationDate.ObservationDateBuilderImpl.class, version="6.23.0")
public interface ObservationDate extends RosettaModelObject, GlobalKey {

	ObservationDateMeta metaData = new ObservationDateMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A date subject to adjustment.
	 */
	Date getUnadjustedDate();
	/**
	 * The date once the adjustment has been performed. (Note that this date may change if the business center holidays change).
	 */
	Date getAdjustedDate();
	/**
	 * Specifies the degree of importance of the observation.
	 */
	BigDecimal getWeight();
	/**
	 * Specifies an identification key for the market observation. This attribute can be used as a reference to assign weights to a series of dates defined in a parametricSchedule.
	 */
	String getObservationReference();
	MetaFields getMeta();

	/*********************** Build Methods  ***********************/
	ObservationDate build();
	
	ObservationDate.ObservationDateBuilder toBuilder();
	
	static ObservationDate.ObservationDateBuilder builder() {
		return new ObservationDate.ObservationDateBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ObservationDate> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ObservationDate> getType() {
		return ObservationDate.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("unadjustedDate"), Date.class, getUnadjustedDate(), this);
		processor.processBasic(path.newSubPath("adjustedDate"), Date.class, getAdjustedDate(), this);
		processor.processBasic(path.newSubPath("weight"), BigDecimal.class, getWeight(), this);
		processor.processBasic(path.newSubPath("observationReference"), String.class, getObservationReference(), this);
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ObservationDateBuilder extends ObservationDate, RosettaModelObjectBuilder, GlobalKey.GlobalKeyBuilder {
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		@Override
		MetaFields.MetaFieldsBuilder getMeta();
		ObservationDate.ObservationDateBuilder setUnadjustedDate(Date unadjustedDate);
		ObservationDate.ObservationDateBuilder setAdjustedDate(Date adjustedDate);
		ObservationDate.ObservationDateBuilder setWeight(BigDecimal weight);
		ObservationDate.ObservationDateBuilder setObservationReference(String observationReference);
		ObservationDate.ObservationDateBuilder setMeta(MetaFields meta);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("unadjustedDate"), Date.class, getUnadjustedDate(), this);
			processor.processBasic(path.newSubPath("adjustedDate"), Date.class, getAdjustedDate(), this);
			processor.processBasic(path.newSubPath("weight"), BigDecimal.class, getWeight(), this);
			processor.processBasic(path.newSubPath("observationReference"), String.class, getObservationReference(), this);
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
		}
		

		ObservationDate.ObservationDateBuilder prune();
	}

	/*********************** Immutable Implementation of ObservationDate  ***********************/
	class ObservationDateImpl implements ObservationDate {
		private final Date unadjustedDate;
		private final Date adjustedDate;
		private final BigDecimal weight;
		private final String observationReference;
		private final MetaFields meta;
		
		protected ObservationDateImpl(ObservationDate.ObservationDateBuilder builder) {
			this.unadjustedDate = builder.getUnadjustedDate();
			this.adjustedDate = builder.getAdjustedDate();
			this.weight = builder.getWeight();
			this.observationReference = builder.getObservationReference();
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("unadjustedDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("unadjustedDate")
		public Date getUnadjustedDate() {
			return unadjustedDate;
		}
		
		@Override
		@RosettaAttribute("adjustedDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("adjustedDate")
		public Date getAdjustedDate() {
			return adjustedDate;
		}
		
		@Override
		@RosettaAttribute("weight")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("weight")
		public BigDecimal getWeight() {
			return weight;
		}
		
		@Override
		@RosettaAttribute("observationReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("observationReference")
		public String getObservationReference() {
			return observationReference;
		}
		
		@Override
		@RosettaAttribute("meta")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("meta")
		@RuneMetaType
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public ObservationDate build() {
			return this;
		}
		
		@Override
		public ObservationDate.ObservationDateBuilder toBuilder() {
			ObservationDate.ObservationDateBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ObservationDate.ObservationDateBuilder builder) {
			ofNullable(getUnadjustedDate()).ifPresent(builder::setUnadjustedDate);
			ofNullable(getAdjustedDate()).ifPresent(builder::setAdjustedDate);
			ofNullable(getWeight()).ifPresent(builder::setWeight);
			ofNullable(getObservationReference()).ifPresent(builder::setObservationReference);
			ofNullable(getMeta()).ifPresent(builder::setMeta);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ObservationDate _that = getType().cast(o);
		
			if (!Objects.equals(unadjustedDate, _that.getUnadjustedDate())) return false;
			if (!Objects.equals(adjustedDate, _that.getAdjustedDate())) return false;
			if (!Objects.equals(weight, _that.getWeight())) return false;
			if (!Objects.equals(observationReference, _that.getObservationReference())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (unadjustedDate != null ? unadjustedDate.hashCode() : 0);
			_result = 31 * _result + (adjustedDate != null ? adjustedDate.hashCode() : 0);
			_result = 31 * _result + (weight != null ? weight.hashCode() : 0);
			_result = 31 * _result + (observationReference != null ? observationReference.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ObservationDate {" +
				"unadjustedDate=" + this.unadjustedDate + ", " +
				"adjustedDate=" + this.adjustedDate + ", " +
				"weight=" + this.weight + ", " +
				"observationReference=" + this.observationReference + ", " +
				"meta=" + this.meta +
			'}';
		}
	}

	/*********************** Builder Implementation of ObservationDate  ***********************/
	class ObservationDateBuilderImpl implements ObservationDate.ObservationDateBuilder {
	
		protected Date unadjustedDate;
		protected Date adjustedDate;
		protected BigDecimal weight;
		protected String observationReference;
		protected MetaFields.MetaFieldsBuilder meta;
		
		@Override
		@RosettaAttribute("unadjustedDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("unadjustedDate")
		public Date getUnadjustedDate() {
			return unadjustedDate;
		}
		
		@Override
		@RosettaAttribute("adjustedDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("adjustedDate")
		public Date getAdjustedDate() {
			return adjustedDate;
		}
		
		@Override
		@RosettaAttribute("weight")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("weight")
		public BigDecimal getWeight() {
			return weight;
		}
		
		@Override
		@RosettaAttribute("observationReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("observationReference")
		public String getObservationReference() {
			return observationReference;
		}
		
		@Override
		@RosettaAttribute("meta")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("meta")
		@RuneMetaType
		public MetaFields.MetaFieldsBuilder getMeta() {
			return meta;
		}
		
		@Override
		public MetaFields.MetaFieldsBuilder getOrCreateMeta() {
			MetaFields.MetaFieldsBuilder result;
			if (meta!=null) {
				result = meta;
			}
			else {
				result = meta = MetaFields.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("unadjustedDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("unadjustedDate")
		@Override
		public ObservationDate.ObservationDateBuilder setUnadjustedDate(Date _unadjustedDate) {
			this.unadjustedDate = _unadjustedDate == null ? null : _unadjustedDate;
			return this;
		}
		
		@RosettaAttribute("adjustedDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("adjustedDate")
		@Override
		public ObservationDate.ObservationDateBuilder setAdjustedDate(Date _adjustedDate) {
			this.adjustedDate = _adjustedDate == null ? null : _adjustedDate;
			return this;
		}
		
		@RosettaAttribute("weight")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("weight")
		@Override
		public ObservationDate.ObservationDateBuilder setWeight(BigDecimal _weight) {
			this.weight = _weight == null ? null : _weight;
			return this;
		}
		
		@RosettaAttribute("observationReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("observationReference")
		@Override
		public ObservationDate.ObservationDateBuilder setObservationReference(String _observationReference) {
			this.observationReference = _observationReference == null ? null : _observationReference;
			return this;
		}
		
		@RosettaAttribute("meta")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("meta")
		@RuneMetaType
		@Override
		public ObservationDate.ObservationDateBuilder setMeta(MetaFields _meta) {
			this.meta = _meta == null ? null : _meta.toBuilder();
			return this;
		}
		
		@Override
		public ObservationDate build() {
			return new ObservationDate.ObservationDateImpl(this);
		}
		
		@Override
		public ObservationDate.ObservationDateBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ObservationDate.ObservationDateBuilder prune() {
			if (meta!=null && !meta.prune().hasData()) meta = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getUnadjustedDate()!=null) return true;
			if (getAdjustedDate()!=null) return true;
			if (getWeight()!=null) return true;
			if (getObservationReference()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ObservationDate.ObservationDateBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ObservationDate.ObservationDateBuilder o = (ObservationDate.ObservationDateBuilder) other;
			
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			
			merger.mergeBasic(getUnadjustedDate(), o.getUnadjustedDate(), this::setUnadjustedDate);
			merger.mergeBasic(getAdjustedDate(), o.getAdjustedDate(), this::setAdjustedDate);
			merger.mergeBasic(getWeight(), o.getWeight(), this::setWeight);
			merger.mergeBasic(getObservationReference(), o.getObservationReference(), this::setObservationReference);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ObservationDate _that = getType().cast(o);
		
			if (!Objects.equals(unadjustedDate, _that.getUnadjustedDate())) return false;
			if (!Objects.equals(adjustedDate, _that.getAdjustedDate())) return false;
			if (!Objects.equals(weight, _that.getWeight())) return false;
			if (!Objects.equals(observationReference, _that.getObservationReference())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (unadjustedDate != null ? unadjustedDate.hashCode() : 0);
			_result = 31 * _result + (adjustedDate != null ? adjustedDate.hashCode() : 0);
			_result = 31 * _result + (weight != null ? weight.hashCode() : 0);
			_result = 31 * _result + (observationReference != null ? observationReference.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ObservationDateBuilder {" +
				"unadjustedDate=" + this.unadjustedDate + ", " +
				"adjustedDate=" + this.adjustedDate + ", " +
				"weight=" + this.weight + ", " +
				"observationReference=" + this.observationReference + ", " +
				"meta=" + this.meta +
			'}';
		}
	}
}
