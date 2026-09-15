package cdm.base.math.metafields;

import cdm.base.math.WeatherUnitEnum;
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

@RosettaDataType(value="FieldWithMetaWeatherUnitEnum", builder=FieldWithMetaWeatherUnitEnum.FieldWithMetaWeatherUnitEnumBuilderImpl.class, version="0.0.0")
@RuneDataType(value="FieldWithMetaWeatherUnitEnum", model="cdm", builder=FieldWithMetaWeatherUnitEnum.FieldWithMetaWeatherUnitEnumBuilderImpl.class, version="0.0.0")
public interface FieldWithMetaWeatherUnitEnum extends RosettaModelObject, FieldWithMeta<WeatherUnitEnum>, GlobalKey {

	FieldWithMetaWeatherUnitEnumMeta metaData = new FieldWithMetaWeatherUnitEnumMeta();

	/*********************** Getter Methods  ***********************/
	WeatherUnitEnum getValue();
	MetaFields getMeta();

	/*********************** Build Methods  ***********************/
	FieldWithMetaWeatherUnitEnum build();
	
	FieldWithMetaWeatherUnitEnum.FieldWithMetaWeatherUnitEnumBuilder toBuilder();
	
	static FieldWithMetaWeatherUnitEnum.FieldWithMetaWeatherUnitEnumBuilder builder() {
		return new FieldWithMetaWeatherUnitEnum.FieldWithMetaWeatherUnitEnumBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FieldWithMetaWeatherUnitEnum> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FieldWithMetaWeatherUnitEnum> getType() {
		return FieldWithMetaWeatherUnitEnum.class;
	}
	
	@Override
	default Class<WeatherUnitEnum> getValueType() {
		return WeatherUnitEnum.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), WeatherUnitEnum.class, getValue(), this);
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FieldWithMetaWeatherUnitEnumBuilder extends FieldWithMetaWeatherUnitEnum, RosettaModelObjectBuilder, FieldWithMeta.FieldWithMetaBuilder<WeatherUnitEnum>, GlobalKey.GlobalKeyBuilder {
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		@Override
		MetaFields.MetaFieldsBuilder getMeta();
		FieldWithMetaWeatherUnitEnum.FieldWithMetaWeatherUnitEnumBuilder setValue(WeatherUnitEnum value);
		FieldWithMetaWeatherUnitEnum.FieldWithMetaWeatherUnitEnumBuilder setMeta(MetaFields meta);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), WeatherUnitEnum.class, getValue(), this);
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
		}
		

		FieldWithMetaWeatherUnitEnum.FieldWithMetaWeatherUnitEnumBuilder prune();
	}

	/*********************** Immutable Implementation of FieldWithMetaWeatherUnitEnum  ***********************/
	class FieldWithMetaWeatherUnitEnumImpl implements FieldWithMetaWeatherUnitEnum {
		private final WeatherUnitEnum value;
		private final MetaFields meta;
		
		protected FieldWithMetaWeatherUnitEnumImpl(FieldWithMetaWeatherUnitEnum.FieldWithMetaWeatherUnitEnumBuilder builder) {
			this.value = builder.getValue();
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("@data")
		public WeatherUnitEnum getValue() {
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
		public FieldWithMetaWeatherUnitEnum build() {
			return this;
		}
		
		@Override
		public FieldWithMetaWeatherUnitEnum.FieldWithMetaWeatherUnitEnumBuilder toBuilder() {
			FieldWithMetaWeatherUnitEnum.FieldWithMetaWeatherUnitEnumBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FieldWithMetaWeatherUnitEnum.FieldWithMetaWeatherUnitEnumBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getMeta()).ifPresent(builder::setMeta);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FieldWithMetaWeatherUnitEnum _that = getType().cast(o);
		
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
			return "FieldWithMetaWeatherUnitEnum {" +
				"value=" + this.value + ", " +
				"meta=" + this.meta +
			'}';
		}
	}

	/*********************** Builder Implementation of FieldWithMetaWeatherUnitEnum  ***********************/
	class FieldWithMetaWeatherUnitEnumBuilderImpl implements FieldWithMetaWeatherUnitEnum.FieldWithMetaWeatherUnitEnumBuilder {
	
		protected WeatherUnitEnum value;
		protected MetaFields.MetaFieldsBuilder meta;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("@data")
		public WeatherUnitEnum getValue() {
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
		public FieldWithMetaWeatherUnitEnum.FieldWithMetaWeatherUnitEnumBuilder setValue(WeatherUnitEnum _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("meta")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("meta")
		@RuneMetaType
		@Override
		public FieldWithMetaWeatherUnitEnum.FieldWithMetaWeatherUnitEnumBuilder setMeta(MetaFields _meta) {
			this.meta = _meta == null ? null : _meta.toBuilder();
			return this;
		}
		
		@Override
		public FieldWithMetaWeatherUnitEnum build() {
			return new FieldWithMetaWeatherUnitEnum.FieldWithMetaWeatherUnitEnumImpl(this);
		}
		
		@Override
		public FieldWithMetaWeatherUnitEnum.FieldWithMetaWeatherUnitEnumBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FieldWithMetaWeatherUnitEnum.FieldWithMetaWeatherUnitEnumBuilder prune() {
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
		public FieldWithMetaWeatherUnitEnum.FieldWithMetaWeatherUnitEnumBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FieldWithMetaWeatherUnitEnum.FieldWithMetaWeatherUnitEnumBuilder o = (FieldWithMetaWeatherUnitEnum.FieldWithMetaWeatherUnitEnumBuilder) other;
			
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FieldWithMetaWeatherUnitEnum _that = getType().cast(o);
		
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
			return "FieldWithMetaWeatherUnitEnumBuilder {" +
				"value=" + this.value + ", " +
				"meta=" + this.meta +
			'}';
		}
	}
}

class FieldWithMetaWeatherUnitEnumMeta extends BasicRosettaMetaData<FieldWithMetaWeatherUnitEnum> {

}
