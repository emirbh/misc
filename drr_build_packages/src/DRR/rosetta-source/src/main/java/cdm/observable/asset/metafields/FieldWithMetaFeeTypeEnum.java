package cdm.observable.asset.metafields;

import cdm.observable.asset.FeeTypeEnum;
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
import java.util.Objects;

import static java.util.Optional.ofNullable;

@RosettaDataType(value="FieldWithMetaFeeTypeEnum", builder=FieldWithMetaFeeTypeEnum.FieldWithMetaFeeTypeEnumBuilderImpl.class, version="0.0.0")
@RuneDataType(value="FieldWithMetaFeeTypeEnum", model="cdm", builder=FieldWithMetaFeeTypeEnum.FieldWithMetaFeeTypeEnumBuilderImpl.class, version="0.0.0")
public interface FieldWithMetaFeeTypeEnum extends RosettaModelObject, FieldWithMeta<FeeTypeEnum>, GlobalKey {

	FieldWithMetaFeeTypeEnumMeta metaData = new FieldWithMetaFeeTypeEnumMeta();

	/*********************** Getter Methods  ***********************/
	FeeTypeEnum getValue();
	MetaFields getMeta();

	/*********************** Build Methods  ***********************/
	FieldWithMetaFeeTypeEnum build();
	
	FieldWithMetaFeeTypeEnum.FieldWithMetaFeeTypeEnumBuilder toBuilder();
	
	static FieldWithMetaFeeTypeEnum.FieldWithMetaFeeTypeEnumBuilder builder() {
		return new FieldWithMetaFeeTypeEnum.FieldWithMetaFeeTypeEnumBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FieldWithMetaFeeTypeEnum> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FieldWithMetaFeeTypeEnum> getType() {
		return FieldWithMetaFeeTypeEnum.class;
	}
	
	@Override
	default Class<FeeTypeEnum> getValueType() {
		return FeeTypeEnum.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), FeeTypeEnum.class, getValue(), this);
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FieldWithMetaFeeTypeEnumBuilder extends FieldWithMetaFeeTypeEnum, RosettaModelObjectBuilder, FieldWithMeta.FieldWithMetaBuilder<FeeTypeEnum>, GlobalKey.GlobalKeyBuilder {
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		@Override
		MetaFields.MetaFieldsBuilder getMeta();
		FieldWithMetaFeeTypeEnum.FieldWithMetaFeeTypeEnumBuilder setValue(FeeTypeEnum value);
		FieldWithMetaFeeTypeEnum.FieldWithMetaFeeTypeEnumBuilder setMeta(MetaFields meta);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), FeeTypeEnum.class, getValue(), this);
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
		}
		

		FieldWithMetaFeeTypeEnum.FieldWithMetaFeeTypeEnumBuilder prune();
	}

	/*********************** Immutable Implementation of FieldWithMetaFeeTypeEnum  ***********************/
	class FieldWithMetaFeeTypeEnumImpl implements FieldWithMetaFeeTypeEnum {
		private final FeeTypeEnum value;
		private final MetaFields meta;
		
		protected FieldWithMetaFeeTypeEnumImpl(FieldWithMetaFeeTypeEnum.FieldWithMetaFeeTypeEnumBuilder builder) {
			this.value = builder.getValue();
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("@data")
		public FeeTypeEnum getValue() {
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
		public FieldWithMetaFeeTypeEnum build() {
			return this;
		}
		
		@Override
		public FieldWithMetaFeeTypeEnum.FieldWithMetaFeeTypeEnumBuilder toBuilder() {
			FieldWithMetaFeeTypeEnum.FieldWithMetaFeeTypeEnumBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FieldWithMetaFeeTypeEnum.FieldWithMetaFeeTypeEnumBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getMeta()).ifPresent(builder::setMeta);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FieldWithMetaFeeTypeEnum _that = getType().cast(o);
		
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
			return "FieldWithMetaFeeTypeEnum {" +
				"value=" + this.value + ", " +
				"meta=" + this.meta +
			'}';
		}
	}

	/*********************** Builder Implementation of FieldWithMetaFeeTypeEnum  ***********************/
	class FieldWithMetaFeeTypeEnumBuilderImpl implements FieldWithMetaFeeTypeEnum.FieldWithMetaFeeTypeEnumBuilder {
	
		protected FeeTypeEnum value;
		protected MetaFields.MetaFieldsBuilder meta;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("@data")
		public FeeTypeEnum getValue() {
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
		public FieldWithMetaFeeTypeEnum.FieldWithMetaFeeTypeEnumBuilder setValue(FeeTypeEnum _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("meta")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("meta")
		@RuneMetaType
		@Override
		public FieldWithMetaFeeTypeEnum.FieldWithMetaFeeTypeEnumBuilder setMeta(MetaFields _meta) {
			this.meta = _meta == null ? null : _meta.toBuilder();
			return this;
		}
		
		@Override
		public FieldWithMetaFeeTypeEnum build() {
			return new FieldWithMetaFeeTypeEnum.FieldWithMetaFeeTypeEnumImpl(this);
		}
		
		@Override
		public FieldWithMetaFeeTypeEnum.FieldWithMetaFeeTypeEnumBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FieldWithMetaFeeTypeEnum.FieldWithMetaFeeTypeEnumBuilder prune() {
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
		public FieldWithMetaFeeTypeEnum.FieldWithMetaFeeTypeEnumBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FieldWithMetaFeeTypeEnum.FieldWithMetaFeeTypeEnumBuilder o = (FieldWithMetaFeeTypeEnum.FieldWithMetaFeeTypeEnumBuilder) other;
			
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FieldWithMetaFeeTypeEnum _that = getType().cast(o);
		
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
			return "FieldWithMetaFeeTypeEnumBuilder {" +
				"value=" + this.value + ", " +
				"meta=" + this.meta +
			'}';
		}
	}
}

class FieldWithMetaFeeTypeEnumMeta extends BasicRosettaMetaData<FieldWithMetaFeeTypeEnum> {

}
