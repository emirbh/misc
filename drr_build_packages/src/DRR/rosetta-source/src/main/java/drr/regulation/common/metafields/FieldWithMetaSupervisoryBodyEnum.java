package drr.regulation.common.metafields;

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
import com.rosetta.model.lib.meta.BasicRosettaMetaData;
import com.rosetta.model.lib.meta.FieldWithMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.metafields.MetaFields;
import drr.regulation.common.SupervisoryBodyEnum;
import java.util.Objects;

import static java.util.Optional.ofNullable;

@RosettaDataType(value="FieldWithMetaSupervisoryBodyEnum", builder=FieldWithMetaSupervisoryBodyEnum.FieldWithMetaSupervisoryBodyEnumBuilderImpl.class, version="0.0.0")
@RuneDataType(value="FieldWithMetaSupervisoryBodyEnum", model="drr", builder=FieldWithMetaSupervisoryBodyEnum.FieldWithMetaSupervisoryBodyEnumBuilderImpl.class, version="0.0.0")
public interface FieldWithMetaSupervisoryBodyEnum extends RosettaModelObject, FieldWithMeta<SupervisoryBodyEnum>, GlobalKey {

	FieldWithMetaSupervisoryBodyEnumMeta metaData = new FieldWithMetaSupervisoryBodyEnumMeta();

	/*********************** Getter Methods  ***********************/
	SupervisoryBodyEnum getValue();
	MetaFields getMeta();

	/*********************** Build Methods  ***********************/
	FieldWithMetaSupervisoryBodyEnum build();
	
	FieldWithMetaSupervisoryBodyEnum.FieldWithMetaSupervisoryBodyEnumBuilder toBuilder();
	
	static FieldWithMetaSupervisoryBodyEnum.FieldWithMetaSupervisoryBodyEnumBuilder builder() {
		return new FieldWithMetaSupervisoryBodyEnum.FieldWithMetaSupervisoryBodyEnumBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FieldWithMetaSupervisoryBodyEnum> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FieldWithMetaSupervisoryBodyEnum> getType() {
		return FieldWithMetaSupervisoryBodyEnum.class;
	}
	
	@Override
	default Class<SupervisoryBodyEnum> getValueType() {
		return SupervisoryBodyEnum.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), SupervisoryBodyEnum.class, getValue(), this);
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FieldWithMetaSupervisoryBodyEnumBuilder extends FieldWithMetaSupervisoryBodyEnum, RosettaModelObjectBuilder, FieldWithMeta.FieldWithMetaBuilder<SupervisoryBodyEnum>, GlobalKey.GlobalKeyBuilder {
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		@Override
		MetaFields.MetaFieldsBuilder getMeta();
		FieldWithMetaSupervisoryBodyEnum.FieldWithMetaSupervisoryBodyEnumBuilder setValue(SupervisoryBodyEnum value);
		FieldWithMetaSupervisoryBodyEnum.FieldWithMetaSupervisoryBodyEnumBuilder setMeta(MetaFields meta);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), SupervisoryBodyEnum.class, getValue(), this);
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
		}
		

		FieldWithMetaSupervisoryBodyEnum.FieldWithMetaSupervisoryBodyEnumBuilder prune();
	}

	/*********************** Immutable Implementation of FieldWithMetaSupervisoryBodyEnum  ***********************/
	class FieldWithMetaSupervisoryBodyEnumImpl implements FieldWithMetaSupervisoryBodyEnum {
		private final SupervisoryBodyEnum value;
		private final MetaFields meta;
		
		protected FieldWithMetaSupervisoryBodyEnumImpl(FieldWithMetaSupervisoryBodyEnum.FieldWithMetaSupervisoryBodyEnumBuilder builder) {
			this.value = builder.getValue();
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("@data")
		public SupervisoryBodyEnum getValue() {
			return value;
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
		public FieldWithMetaSupervisoryBodyEnum build() {
			return this;
		}
		
		@Override
		public FieldWithMetaSupervisoryBodyEnum.FieldWithMetaSupervisoryBodyEnumBuilder toBuilder() {
			FieldWithMetaSupervisoryBodyEnum.FieldWithMetaSupervisoryBodyEnumBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FieldWithMetaSupervisoryBodyEnum.FieldWithMetaSupervisoryBodyEnumBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getMeta()).ifPresent(builder::setMeta);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FieldWithMetaSupervisoryBodyEnum _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FieldWithMetaSupervisoryBodyEnum {" +
				"value=" + this.value + ", " +
				"meta=" + this.meta +
			'}';
		}
	}

	/*********************** Builder Implementation of FieldWithMetaSupervisoryBodyEnum  ***********************/
	class FieldWithMetaSupervisoryBodyEnumBuilderImpl implements FieldWithMetaSupervisoryBodyEnum.FieldWithMetaSupervisoryBodyEnumBuilder {
	
		protected SupervisoryBodyEnum value;
		protected MetaFields.MetaFieldsBuilder meta;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("@data")
		public SupervisoryBodyEnum getValue() {
			return value;
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
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("@data")
		@Override
		public FieldWithMetaSupervisoryBodyEnum.FieldWithMetaSupervisoryBodyEnumBuilder setValue(SupervisoryBodyEnum _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("meta")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("meta")
		@RuneMetaType
		@Override
		public FieldWithMetaSupervisoryBodyEnum.FieldWithMetaSupervisoryBodyEnumBuilder setMeta(MetaFields _meta) {
			this.meta = _meta == null ? null : _meta.toBuilder();
			return this;
		}
		
		@Override
		public FieldWithMetaSupervisoryBodyEnum build() {
			return new FieldWithMetaSupervisoryBodyEnum.FieldWithMetaSupervisoryBodyEnumImpl(this);
		}
		
		@Override
		public FieldWithMetaSupervisoryBodyEnum.FieldWithMetaSupervisoryBodyEnumBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FieldWithMetaSupervisoryBodyEnum.FieldWithMetaSupervisoryBodyEnumBuilder prune() {
			if (meta!=null && !meta.prune().hasData()) meta = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FieldWithMetaSupervisoryBodyEnum.FieldWithMetaSupervisoryBodyEnumBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FieldWithMetaSupervisoryBodyEnum.FieldWithMetaSupervisoryBodyEnumBuilder o = (FieldWithMetaSupervisoryBodyEnum.FieldWithMetaSupervisoryBodyEnumBuilder) other;
			
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FieldWithMetaSupervisoryBodyEnum _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FieldWithMetaSupervisoryBodyEnumBuilder {" +
				"value=" + this.value + ", " +
				"meta=" + this.meta +
			'}';
		}
	}
}

class FieldWithMetaSupervisoryBodyEnumMeta extends BasicRosettaMetaData<FieldWithMetaSupervisoryBodyEnum> {

}
