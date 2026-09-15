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
import drr.regulation.common.RegimeNameEnum;
import java.util.Objects;

import static java.util.Optional.ofNullable;

@RosettaDataType(value="FieldWithMetaRegimeNameEnum", builder=FieldWithMetaRegimeNameEnum.FieldWithMetaRegimeNameEnumBuilderImpl.class, version="0.0.0")
@RuneDataType(value="FieldWithMetaRegimeNameEnum", model="drr", builder=FieldWithMetaRegimeNameEnum.FieldWithMetaRegimeNameEnumBuilderImpl.class, version="0.0.0")
public interface FieldWithMetaRegimeNameEnum extends RosettaModelObject, FieldWithMeta<RegimeNameEnum>, GlobalKey {

	FieldWithMetaRegimeNameEnumMeta metaData = new FieldWithMetaRegimeNameEnumMeta();

	/*********************** Getter Methods  ***********************/
	RegimeNameEnum getValue();
	MetaFields getMeta();

	/*********************** Build Methods  ***********************/
	FieldWithMetaRegimeNameEnum build();
	
	FieldWithMetaRegimeNameEnum.FieldWithMetaRegimeNameEnumBuilder toBuilder();
	
	static FieldWithMetaRegimeNameEnum.FieldWithMetaRegimeNameEnumBuilder builder() {
		return new FieldWithMetaRegimeNameEnum.FieldWithMetaRegimeNameEnumBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FieldWithMetaRegimeNameEnum> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FieldWithMetaRegimeNameEnum> getType() {
		return FieldWithMetaRegimeNameEnum.class;
	}
	
	@Override
	default Class<RegimeNameEnum> getValueType() {
		return RegimeNameEnum.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), RegimeNameEnum.class, getValue(), this);
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FieldWithMetaRegimeNameEnumBuilder extends FieldWithMetaRegimeNameEnum, RosettaModelObjectBuilder, FieldWithMeta.FieldWithMetaBuilder<RegimeNameEnum>, GlobalKey.GlobalKeyBuilder {
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		@Override
		MetaFields.MetaFieldsBuilder getMeta();
		FieldWithMetaRegimeNameEnum.FieldWithMetaRegimeNameEnumBuilder setValue(RegimeNameEnum value);
		FieldWithMetaRegimeNameEnum.FieldWithMetaRegimeNameEnumBuilder setMeta(MetaFields meta);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), RegimeNameEnum.class, getValue(), this);
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
		}
		

		FieldWithMetaRegimeNameEnum.FieldWithMetaRegimeNameEnumBuilder prune();
	}

	/*********************** Immutable Implementation of FieldWithMetaRegimeNameEnum  ***********************/
	class FieldWithMetaRegimeNameEnumImpl implements FieldWithMetaRegimeNameEnum {
		private final RegimeNameEnum value;
		private final MetaFields meta;
		
		protected FieldWithMetaRegimeNameEnumImpl(FieldWithMetaRegimeNameEnum.FieldWithMetaRegimeNameEnumBuilder builder) {
			this.value = builder.getValue();
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("@data")
		public RegimeNameEnum getValue() {
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
		public FieldWithMetaRegimeNameEnum build() {
			return this;
		}
		
		@Override
		public FieldWithMetaRegimeNameEnum.FieldWithMetaRegimeNameEnumBuilder toBuilder() {
			FieldWithMetaRegimeNameEnum.FieldWithMetaRegimeNameEnumBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FieldWithMetaRegimeNameEnum.FieldWithMetaRegimeNameEnumBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getMeta()).ifPresent(builder::setMeta);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FieldWithMetaRegimeNameEnum _that = getType().cast(o);
		
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
			return "FieldWithMetaRegimeNameEnum {" +
				"value=" + this.value + ", " +
				"meta=" + this.meta +
			'}';
		}
	}

	/*********************** Builder Implementation of FieldWithMetaRegimeNameEnum  ***********************/
	class FieldWithMetaRegimeNameEnumBuilderImpl implements FieldWithMetaRegimeNameEnum.FieldWithMetaRegimeNameEnumBuilder {
	
		protected RegimeNameEnum value;
		protected MetaFields.MetaFieldsBuilder meta;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("@data")
		public RegimeNameEnum getValue() {
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
		public FieldWithMetaRegimeNameEnum.FieldWithMetaRegimeNameEnumBuilder setValue(RegimeNameEnum _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("meta")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("meta")
		@RuneMetaType
		@Override
		public FieldWithMetaRegimeNameEnum.FieldWithMetaRegimeNameEnumBuilder setMeta(MetaFields _meta) {
			this.meta = _meta == null ? null : _meta.toBuilder();
			return this;
		}
		
		@Override
		public FieldWithMetaRegimeNameEnum build() {
			return new FieldWithMetaRegimeNameEnum.FieldWithMetaRegimeNameEnumImpl(this);
		}
		
		@Override
		public FieldWithMetaRegimeNameEnum.FieldWithMetaRegimeNameEnumBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FieldWithMetaRegimeNameEnum.FieldWithMetaRegimeNameEnumBuilder prune() {
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
		public FieldWithMetaRegimeNameEnum.FieldWithMetaRegimeNameEnumBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FieldWithMetaRegimeNameEnum.FieldWithMetaRegimeNameEnumBuilder o = (FieldWithMetaRegimeNameEnum.FieldWithMetaRegimeNameEnumBuilder) other;
			
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FieldWithMetaRegimeNameEnum _that = getType().cast(o);
		
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
			return "FieldWithMetaRegimeNameEnumBuilder {" +
				"value=" + this.value + ", " +
				"meta=" + this.meta +
			'}';
		}
	}
}

class FieldWithMetaRegimeNameEnumMeta extends BasicRosettaMetaData<FieldWithMetaRegimeNameEnum> {

}
