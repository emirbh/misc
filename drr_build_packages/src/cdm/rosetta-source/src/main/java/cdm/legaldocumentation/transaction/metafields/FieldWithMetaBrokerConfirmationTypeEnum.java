package cdm.legaldocumentation.transaction.metafields;

import cdm.legaldocumentation.transaction.BrokerConfirmationTypeEnum;
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

@RosettaDataType(value="FieldWithMetaBrokerConfirmationTypeEnum", builder=FieldWithMetaBrokerConfirmationTypeEnum.FieldWithMetaBrokerConfirmationTypeEnumBuilderImpl.class, version="0.0.0")
@RuneDataType(value="FieldWithMetaBrokerConfirmationTypeEnum", model="cdm", builder=FieldWithMetaBrokerConfirmationTypeEnum.FieldWithMetaBrokerConfirmationTypeEnumBuilderImpl.class, version="0.0.0")
public interface FieldWithMetaBrokerConfirmationTypeEnum extends RosettaModelObject, FieldWithMeta<BrokerConfirmationTypeEnum>, GlobalKey {

	FieldWithMetaBrokerConfirmationTypeEnumMeta metaData = new FieldWithMetaBrokerConfirmationTypeEnumMeta();

	/*********************** Getter Methods  ***********************/
	BrokerConfirmationTypeEnum getValue();
	MetaFields getMeta();

	/*********************** Build Methods  ***********************/
	FieldWithMetaBrokerConfirmationTypeEnum build();
	
	FieldWithMetaBrokerConfirmationTypeEnum.FieldWithMetaBrokerConfirmationTypeEnumBuilder toBuilder();
	
	static FieldWithMetaBrokerConfirmationTypeEnum.FieldWithMetaBrokerConfirmationTypeEnumBuilder builder() {
		return new FieldWithMetaBrokerConfirmationTypeEnum.FieldWithMetaBrokerConfirmationTypeEnumBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FieldWithMetaBrokerConfirmationTypeEnum> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FieldWithMetaBrokerConfirmationTypeEnum> getType() {
		return FieldWithMetaBrokerConfirmationTypeEnum.class;
	}
	
	@Override
	default Class<BrokerConfirmationTypeEnum> getValueType() {
		return BrokerConfirmationTypeEnum.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), BrokerConfirmationTypeEnum.class, getValue(), this);
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FieldWithMetaBrokerConfirmationTypeEnumBuilder extends FieldWithMetaBrokerConfirmationTypeEnum, RosettaModelObjectBuilder, FieldWithMeta.FieldWithMetaBuilder<BrokerConfirmationTypeEnum>, GlobalKey.GlobalKeyBuilder {
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		@Override
		MetaFields.MetaFieldsBuilder getMeta();
		FieldWithMetaBrokerConfirmationTypeEnum.FieldWithMetaBrokerConfirmationTypeEnumBuilder setValue(BrokerConfirmationTypeEnum value);
		FieldWithMetaBrokerConfirmationTypeEnum.FieldWithMetaBrokerConfirmationTypeEnumBuilder setMeta(MetaFields meta);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), BrokerConfirmationTypeEnum.class, getValue(), this);
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
		}
		

		FieldWithMetaBrokerConfirmationTypeEnum.FieldWithMetaBrokerConfirmationTypeEnumBuilder prune();
	}

	/*********************** Immutable Implementation of FieldWithMetaBrokerConfirmationTypeEnum  ***********************/
	class FieldWithMetaBrokerConfirmationTypeEnumImpl implements FieldWithMetaBrokerConfirmationTypeEnum {
		private final BrokerConfirmationTypeEnum value;
		private final MetaFields meta;
		
		protected FieldWithMetaBrokerConfirmationTypeEnumImpl(FieldWithMetaBrokerConfirmationTypeEnum.FieldWithMetaBrokerConfirmationTypeEnumBuilder builder) {
			this.value = builder.getValue();
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("@data")
		public BrokerConfirmationTypeEnum getValue() {
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
		public FieldWithMetaBrokerConfirmationTypeEnum build() {
			return this;
		}
		
		@Override
		public FieldWithMetaBrokerConfirmationTypeEnum.FieldWithMetaBrokerConfirmationTypeEnumBuilder toBuilder() {
			FieldWithMetaBrokerConfirmationTypeEnum.FieldWithMetaBrokerConfirmationTypeEnumBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FieldWithMetaBrokerConfirmationTypeEnum.FieldWithMetaBrokerConfirmationTypeEnumBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getMeta()).ifPresent(builder::setMeta);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FieldWithMetaBrokerConfirmationTypeEnum _that = getType().cast(o);
		
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
			return "FieldWithMetaBrokerConfirmationTypeEnum {" +
				"value=" + this.value + ", " +
				"meta=" + this.meta +
			'}';
		}
	}

	/*********************** Builder Implementation of FieldWithMetaBrokerConfirmationTypeEnum  ***********************/
	class FieldWithMetaBrokerConfirmationTypeEnumBuilderImpl implements FieldWithMetaBrokerConfirmationTypeEnum.FieldWithMetaBrokerConfirmationTypeEnumBuilder {
	
		protected BrokerConfirmationTypeEnum value;
		protected MetaFields.MetaFieldsBuilder meta;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("@data")
		public BrokerConfirmationTypeEnum getValue() {
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
		public FieldWithMetaBrokerConfirmationTypeEnum.FieldWithMetaBrokerConfirmationTypeEnumBuilder setValue(BrokerConfirmationTypeEnum _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("meta")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("meta")
		@RuneMetaType
		@Override
		public FieldWithMetaBrokerConfirmationTypeEnum.FieldWithMetaBrokerConfirmationTypeEnumBuilder setMeta(MetaFields _meta) {
			this.meta = _meta == null ? null : _meta.toBuilder();
			return this;
		}
		
		@Override
		public FieldWithMetaBrokerConfirmationTypeEnum build() {
			return new FieldWithMetaBrokerConfirmationTypeEnum.FieldWithMetaBrokerConfirmationTypeEnumImpl(this);
		}
		
		@Override
		public FieldWithMetaBrokerConfirmationTypeEnum.FieldWithMetaBrokerConfirmationTypeEnumBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FieldWithMetaBrokerConfirmationTypeEnum.FieldWithMetaBrokerConfirmationTypeEnumBuilder prune() {
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
		public FieldWithMetaBrokerConfirmationTypeEnum.FieldWithMetaBrokerConfirmationTypeEnumBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FieldWithMetaBrokerConfirmationTypeEnum.FieldWithMetaBrokerConfirmationTypeEnumBuilder o = (FieldWithMetaBrokerConfirmationTypeEnum.FieldWithMetaBrokerConfirmationTypeEnumBuilder) other;
			
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FieldWithMetaBrokerConfirmationTypeEnum _that = getType().cast(o);
		
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
			return "FieldWithMetaBrokerConfirmationTypeEnumBuilder {" +
				"value=" + this.value + ", " +
				"meta=" + this.meta +
			'}';
		}
	}
}

class FieldWithMetaBrokerConfirmationTypeEnumMeta extends BasicRosettaMetaData<FieldWithMetaBrokerConfirmationTypeEnum> {

}
