package drr.regulation.common;

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
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.regulation.common.meta.TechnicalRecordIdMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Provides the unique technical identification of the original data for which the status is provided for the BDR.
 * @version 7.7.0
 */
@RosettaDataType(value="TechnicalRecordId", builder=TechnicalRecordId.TechnicalRecordIdBuilderImpl.class, version="7.7.0")
@RuneDataType(value="TechnicalRecordId", model="drr", builder=TechnicalRecordId.TechnicalRecordIdBuilderImpl.class, version="7.7.0")
public interface TechnicalRecordId extends RosettaModelObject {

	TechnicalRecordIdMeta metaData = new TechnicalRecordIdMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Technical identification of the original data for which the status is provided for the BDR.
	 */
	FieldWithMetaString getId();
	/**
	 * Specifies whether the technical identification is unique for every submission of a transaction.
	 */
	Boolean getIsUnique();

	/*********************** Build Methods  ***********************/
	TechnicalRecordId build();
	
	TechnicalRecordId.TechnicalRecordIdBuilder toBuilder();
	
	static TechnicalRecordId.TechnicalRecordIdBuilder builder() {
		return new TechnicalRecordId.TechnicalRecordIdBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TechnicalRecordId> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends TechnicalRecordId> getType() {
		return TechnicalRecordId.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("id"), processor, FieldWithMetaString.class, getId());
		processor.processBasic(path.newSubPath("isUnique"), Boolean.class, getIsUnique(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface TechnicalRecordIdBuilder extends TechnicalRecordId, RosettaModelObjectBuilder {
		FieldWithMetaString.FieldWithMetaStringBuilder getOrCreateId();
		@Override
		FieldWithMetaString.FieldWithMetaStringBuilder getId();
		TechnicalRecordId.TechnicalRecordIdBuilder setId(FieldWithMetaString id);
		TechnicalRecordId.TechnicalRecordIdBuilder setIdValue(String id);
		TechnicalRecordId.TechnicalRecordIdBuilder setIsUnique(Boolean isUnique);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("id"), processor, FieldWithMetaString.FieldWithMetaStringBuilder.class, getId());
			processor.processBasic(path.newSubPath("isUnique"), Boolean.class, getIsUnique(), this);
		}
		

		TechnicalRecordId.TechnicalRecordIdBuilder prune();
	}

	/*********************** Immutable Implementation of TechnicalRecordId  ***********************/
	class TechnicalRecordIdImpl implements TechnicalRecordId {
		private final FieldWithMetaString id;
		private final Boolean isUnique;
		
		protected TechnicalRecordIdImpl(TechnicalRecordId.TechnicalRecordIdBuilder builder) {
			this.id = ofNullable(builder.getId()).map(f->f.build()).orElse(null);
			this.isUnique = builder.getIsUnique();
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public FieldWithMetaString getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("isUnique")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("isUnique")
		public Boolean getIsUnique() {
			return isUnique;
		}
		
		@Override
		public TechnicalRecordId build() {
			return this;
		}
		
		@Override
		public TechnicalRecordId.TechnicalRecordIdBuilder toBuilder() {
			TechnicalRecordId.TechnicalRecordIdBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TechnicalRecordId.TechnicalRecordIdBuilder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getIsUnique()).ifPresent(builder::setIsUnique);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TechnicalRecordId _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(isUnique, _that.getIsUnique())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (isUnique != null ? isUnique.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TechnicalRecordId {" +
				"id=" + this.id + ", " +
				"isUnique=" + this.isUnique +
			'}';
		}
	}

	/*********************** Builder Implementation of TechnicalRecordId  ***********************/
	class TechnicalRecordIdBuilderImpl implements TechnicalRecordId.TechnicalRecordIdBuilder {
	
		protected FieldWithMetaString.FieldWithMetaStringBuilder id;
		protected Boolean isUnique;
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public FieldWithMetaString.FieldWithMetaStringBuilder getId() {
			return id;
		}
		
		@Override
		public FieldWithMetaString.FieldWithMetaStringBuilder getOrCreateId() {
			FieldWithMetaString.FieldWithMetaStringBuilder result;
			if (id!=null) {
				result = id;
			}
			else {
				result = id = FieldWithMetaString.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("isUnique")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("isUnique")
		public Boolean getIsUnique() {
			return isUnique;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public TechnicalRecordId.TechnicalRecordIdBuilder setId(FieldWithMetaString _id) {
			this.id = _id == null ? null : _id.toBuilder();
			return this;
		}
		
		@Override
		public TechnicalRecordId.TechnicalRecordIdBuilder setIdValue(String _id) {
			this.getOrCreateId().setValue(_id);
			return this;
		}
		
		@RosettaAttribute("isUnique")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("isUnique")
		@Override
		public TechnicalRecordId.TechnicalRecordIdBuilder setIsUnique(Boolean _isUnique) {
			this.isUnique = _isUnique == null ? null : _isUnique;
			return this;
		}
		
		@Override
		public TechnicalRecordId build() {
			return new TechnicalRecordId.TechnicalRecordIdImpl(this);
		}
		
		@Override
		public TechnicalRecordId.TechnicalRecordIdBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TechnicalRecordId.TechnicalRecordIdBuilder prune() {
			if (id!=null && !id.prune().hasData()) id = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			if (getIsUnique()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TechnicalRecordId.TechnicalRecordIdBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TechnicalRecordId.TechnicalRecordIdBuilder o = (TechnicalRecordId.TechnicalRecordIdBuilder) other;
			
			merger.mergeRosetta(getId(), o.getId(), this::setId);
			
			merger.mergeBasic(getIsUnique(), o.getIsUnique(), this::setIsUnique);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TechnicalRecordId _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(isUnique, _that.getIsUnique())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (isUnique != null ? isUnique.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TechnicalRecordIdBuilder {" +
				"id=" + this.id + ", " +
				"isUnique=" + this.isUnique +
			'}';
		}
	}
}
