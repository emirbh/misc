package drr.standards.iosco.upi;

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
import drr.standards.iosco.upi.meta.AnnaDsbHeaderMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 7.7.0
 */
@RosettaDataType(value="AnnaDsbHeader", builder=AnnaDsbHeader.AnnaDsbHeaderBuilderImpl.class, version="7.7.0")
@RuneDataType(value="AnnaDsbHeader", model="drr", builder=AnnaDsbHeader.AnnaDsbHeaderBuilderImpl.class, version="7.7.0")
public interface AnnaDsbHeader extends RosettaModelObject {

	AnnaDsbHeaderMeta metaData = new AnnaDsbHeaderMeta();

	/*********************** Getter Methods  ***********************/
	AnnaDsbInstrumentTypeEnum getInstrumentType();
	AnnaDsbUseCaseEnum getUseCase();
	AnnaDsbLevelEnum getLevel();
	AnnaDsbAssetClassEnum getAssetClass();

	/*********************** Build Methods  ***********************/
	AnnaDsbHeader build();
	
	AnnaDsbHeader.AnnaDsbHeaderBuilder toBuilder();
	
	static AnnaDsbHeader.AnnaDsbHeaderBuilder builder() {
		return new AnnaDsbHeader.AnnaDsbHeaderBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AnnaDsbHeader> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AnnaDsbHeader> getType() {
		return AnnaDsbHeader.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("InstrumentType"), AnnaDsbInstrumentTypeEnum.class, getInstrumentType(), this);
		processor.processBasic(path.newSubPath("UseCase"), AnnaDsbUseCaseEnum.class, getUseCase(), this);
		processor.processBasic(path.newSubPath("Level"), AnnaDsbLevelEnum.class, getLevel(), this);
		processor.processBasic(path.newSubPath("AssetClass"), AnnaDsbAssetClassEnum.class, getAssetClass(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface AnnaDsbHeaderBuilder extends AnnaDsbHeader, RosettaModelObjectBuilder {
		AnnaDsbHeader.AnnaDsbHeaderBuilder setInstrumentType(AnnaDsbInstrumentTypeEnum InstrumentType);
		AnnaDsbHeader.AnnaDsbHeaderBuilder setUseCase(AnnaDsbUseCaseEnum UseCase);
		AnnaDsbHeader.AnnaDsbHeaderBuilder setLevel(AnnaDsbLevelEnum Level);
		AnnaDsbHeader.AnnaDsbHeaderBuilder setAssetClass(AnnaDsbAssetClassEnum AssetClass);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("InstrumentType"), AnnaDsbInstrumentTypeEnum.class, getInstrumentType(), this);
			processor.processBasic(path.newSubPath("UseCase"), AnnaDsbUseCaseEnum.class, getUseCase(), this);
			processor.processBasic(path.newSubPath("Level"), AnnaDsbLevelEnum.class, getLevel(), this);
			processor.processBasic(path.newSubPath("AssetClass"), AnnaDsbAssetClassEnum.class, getAssetClass(), this);
		}
		

		AnnaDsbHeader.AnnaDsbHeaderBuilder prune();
	}

	/*********************** Immutable Implementation of AnnaDsbHeader  ***********************/
	class AnnaDsbHeaderImpl implements AnnaDsbHeader {
		private final AnnaDsbInstrumentTypeEnum instrumentType;
		private final AnnaDsbUseCaseEnum useCase;
		private final AnnaDsbLevelEnum level;
		private final AnnaDsbAssetClassEnum assetClass;
		
		protected AnnaDsbHeaderImpl(AnnaDsbHeader.AnnaDsbHeaderBuilder builder) {
			this.instrumentType = builder.getInstrumentType();
			this.useCase = builder.getUseCase();
			this.level = builder.getLevel();
			this.assetClass = builder.getAssetClass();
		}
		
		@Override
		@RosettaAttribute("InstrumentType")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("InstrumentType")
		public AnnaDsbInstrumentTypeEnum getInstrumentType() {
			return instrumentType;
		}
		
		@Override
		@RosettaAttribute("UseCase")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("UseCase")
		public AnnaDsbUseCaseEnum getUseCase() {
			return useCase;
		}
		
		@Override
		@RosettaAttribute("Level")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("Level")
		public AnnaDsbLevelEnum getLevel() {
			return level;
		}
		
		@Override
		@RosettaAttribute("AssetClass")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("AssetClass")
		public AnnaDsbAssetClassEnum getAssetClass() {
			return assetClass;
		}
		
		@Override
		public AnnaDsbHeader build() {
			return this;
		}
		
		@Override
		public AnnaDsbHeader.AnnaDsbHeaderBuilder toBuilder() {
			AnnaDsbHeader.AnnaDsbHeaderBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AnnaDsbHeader.AnnaDsbHeaderBuilder builder) {
			ofNullable(getInstrumentType()).ifPresent(builder::setInstrumentType);
			ofNullable(getUseCase()).ifPresent(builder::setUseCase);
			ofNullable(getLevel()).ifPresent(builder::setLevel);
			ofNullable(getAssetClass()).ifPresent(builder::setAssetClass);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AnnaDsbHeader _that = getType().cast(o);
		
			if (!Objects.equals(instrumentType, _that.getInstrumentType())) return false;
			if (!Objects.equals(useCase, _that.getUseCase())) return false;
			if (!Objects.equals(level, _that.getLevel())) return false;
			if (!Objects.equals(assetClass, _that.getAssetClass())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (instrumentType != null ? instrumentType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (useCase != null ? useCase.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (level != null ? level.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (assetClass != null ? assetClass.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AnnaDsbHeader {" +
				"InstrumentType=" + this.instrumentType + ", " +
				"UseCase=" + this.useCase + ", " +
				"Level=" + this.level + ", " +
				"AssetClass=" + this.assetClass +
			'}';
		}
	}

	/*********************** Builder Implementation of AnnaDsbHeader  ***********************/
	class AnnaDsbHeaderBuilderImpl implements AnnaDsbHeader.AnnaDsbHeaderBuilder {
	
		protected AnnaDsbInstrumentTypeEnum instrumentType;
		protected AnnaDsbUseCaseEnum useCase;
		protected AnnaDsbLevelEnum level;
		protected AnnaDsbAssetClassEnum assetClass;
		
		@Override
		@RosettaAttribute("InstrumentType")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("InstrumentType")
		public AnnaDsbInstrumentTypeEnum getInstrumentType() {
			return instrumentType;
		}
		
		@Override
		@RosettaAttribute("UseCase")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("UseCase")
		public AnnaDsbUseCaseEnum getUseCase() {
			return useCase;
		}
		
		@Override
		@RosettaAttribute("Level")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("Level")
		public AnnaDsbLevelEnum getLevel() {
			return level;
		}
		
		@Override
		@RosettaAttribute("AssetClass")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("AssetClass")
		public AnnaDsbAssetClassEnum getAssetClass() {
			return assetClass;
		}
		
		@RosettaAttribute("InstrumentType")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("InstrumentType")
		@Override
		public AnnaDsbHeader.AnnaDsbHeaderBuilder setInstrumentType(AnnaDsbInstrumentTypeEnum _instrumentType) {
			this.instrumentType = _instrumentType == null ? null : _instrumentType;
			return this;
		}
		
		@RosettaAttribute("UseCase")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("UseCase")
		@Override
		public AnnaDsbHeader.AnnaDsbHeaderBuilder setUseCase(AnnaDsbUseCaseEnum _useCase) {
			this.useCase = _useCase == null ? null : _useCase;
			return this;
		}
		
		@RosettaAttribute("Level")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("Level")
		@Override
		public AnnaDsbHeader.AnnaDsbHeaderBuilder setLevel(AnnaDsbLevelEnum _level) {
			this.level = _level == null ? null : _level;
			return this;
		}
		
		@RosettaAttribute("AssetClass")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("AssetClass")
		@Override
		public AnnaDsbHeader.AnnaDsbHeaderBuilder setAssetClass(AnnaDsbAssetClassEnum _assetClass) {
			this.assetClass = _assetClass == null ? null : _assetClass;
			return this;
		}
		
		@Override
		public AnnaDsbHeader build() {
			return new AnnaDsbHeader.AnnaDsbHeaderImpl(this);
		}
		
		@Override
		public AnnaDsbHeader.AnnaDsbHeaderBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AnnaDsbHeader.AnnaDsbHeaderBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getInstrumentType()!=null) return true;
			if (getUseCase()!=null) return true;
			if (getLevel()!=null) return true;
			if (getAssetClass()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AnnaDsbHeader.AnnaDsbHeaderBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AnnaDsbHeader.AnnaDsbHeaderBuilder o = (AnnaDsbHeader.AnnaDsbHeaderBuilder) other;
			
			
			merger.mergeBasic(getInstrumentType(), o.getInstrumentType(), this::setInstrumentType);
			merger.mergeBasic(getUseCase(), o.getUseCase(), this::setUseCase);
			merger.mergeBasic(getLevel(), o.getLevel(), this::setLevel);
			merger.mergeBasic(getAssetClass(), o.getAssetClass(), this::setAssetClass);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AnnaDsbHeader _that = getType().cast(o);
		
			if (!Objects.equals(instrumentType, _that.getInstrumentType())) return false;
			if (!Objects.equals(useCase, _that.getUseCase())) return false;
			if (!Objects.equals(level, _that.getLevel())) return false;
			if (!Objects.equals(assetClass, _that.getAssetClass())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (instrumentType != null ? instrumentType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (useCase != null ? useCase.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (level != null ? level.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (assetClass != null ? assetClass.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AnnaDsbHeaderBuilder {" +
				"InstrumentType=" + this.instrumentType + ", " +
				"UseCase=" + this.useCase + ", " +
				"Level=" + this.level + ", " +
				"AssetClass=" + this.assetClass +
			'}';
		}
	}
}
