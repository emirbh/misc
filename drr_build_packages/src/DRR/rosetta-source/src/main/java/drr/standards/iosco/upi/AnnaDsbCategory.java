package drr.standards.iosco.upi;

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
import drr.standards.iosco.upi.meta.AnnaDsbCategoryMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 7.7.0
 */
@RosettaDataType(value="AnnaDsbCategory", builder=AnnaDsbCategory.AnnaDsbCategoryBuilderImpl.class, version="7.7.0")
@RuneDataType(value="AnnaDsbCategory", model="drr", builder=AnnaDsbCategory.AnnaDsbCategoryBuilderImpl.class, version="7.7.0")
public interface AnnaDsbCategory extends RosettaModelObject {

	AnnaDsbCategoryMeta metaData = new AnnaDsbCategoryMeta();

	/*********************** Getter Methods  ***********************/
	AnnaDsbRateGroup getSwaps();
	AnnaDsbRateGroup getNonListedAndComplexListedOptions();

	/*********************** Build Methods  ***********************/
	AnnaDsbCategory build();
	
	AnnaDsbCategory.AnnaDsbCategoryBuilder toBuilder();
	
	static AnnaDsbCategory.AnnaDsbCategoryBuilder builder() {
		return new AnnaDsbCategory.AnnaDsbCategoryBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AnnaDsbCategory> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AnnaDsbCategory> getType() {
		return AnnaDsbCategory.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("Swaps"), processor, AnnaDsbRateGroup.class, getSwaps());
		processRosetta(path.newSubPath("NonListedAndComplexListedOptions"), processor, AnnaDsbRateGroup.class, getNonListedAndComplexListedOptions());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AnnaDsbCategoryBuilder extends AnnaDsbCategory, RosettaModelObjectBuilder {
		AnnaDsbRateGroup.AnnaDsbRateGroupBuilder getOrCreateSwaps();
		@Override
		AnnaDsbRateGroup.AnnaDsbRateGroupBuilder getSwaps();
		AnnaDsbRateGroup.AnnaDsbRateGroupBuilder getOrCreateNonListedAndComplexListedOptions();
		@Override
		AnnaDsbRateGroup.AnnaDsbRateGroupBuilder getNonListedAndComplexListedOptions();
		AnnaDsbCategory.AnnaDsbCategoryBuilder setSwaps(AnnaDsbRateGroup Swaps);
		AnnaDsbCategory.AnnaDsbCategoryBuilder setNonListedAndComplexListedOptions(AnnaDsbRateGroup NonListedAndComplexListedOptions);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("Swaps"), processor, AnnaDsbRateGroup.AnnaDsbRateGroupBuilder.class, getSwaps());
			processRosetta(path.newSubPath("NonListedAndComplexListedOptions"), processor, AnnaDsbRateGroup.AnnaDsbRateGroupBuilder.class, getNonListedAndComplexListedOptions());
		}
		

		AnnaDsbCategory.AnnaDsbCategoryBuilder prune();
	}

	/*********************** Immutable Implementation of AnnaDsbCategory  ***********************/
	class AnnaDsbCategoryImpl implements AnnaDsbCategory {
		private final AnnaDsbRateGroup swaps;
		private final AnnaDsbRateGroup nonListedAndComplexListedOptions;
		
		protected AnnaDsbCategoryImpl(AnnaDsbCategory.AnnaDsbCategoryBuilder builder) {
			this.swaps = ofNullable(builder.getSwaps()).map(f->f.build()).orElse(null);
			this.nonListedAndComplexListedOptions = ofNullable(builder.getNonListedAndComplexListedOptions()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("Swaps")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("Swaps")
		public AnnaDsbRateGroup getSwaps() {
			return swaps;
		}
		
		@Override
		@RosettaAttribute("NonListedAndComplexListedOptions")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("NonListedAndComplexListedOptions")
		public AnnaDsbRateGroup getNonListedAndComplexListedOptions() {
			return nonListedAndComplexListedOptions;
		}
		
		@Override
		public AnnaDsbCategory build() {
			return this;
		}
		
		@Override
		public AnnaDsbCategory.AnnaDsbCategoryBuilder toBuilder() {
			AnnaDsbCategory.AnnaDsbCategoryBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AnnaDsbCategory.AnnaDsbCategoryBuilder builder) {
			ofNullable(getSwaps()).ifPresent(builder::setSwaps);
			ofNullable(getNonListedAndComplexListedOptions()).ifPresent(builder::setNonListedAndComplexListedOptions);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AnnaDsbCategory _that = getType().cast(o);
		
			if (!Objects.equals(swaps, _that.getSwaps())) return false;
			if (!Objects.equals(nonListedAndComplexListedOptions, _that.getNonListedAndComplexListedOptions())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (swaps != null ? swaps.hashCode() : 0);
			_result = 31 * _result + (nonListedAndComplexListedOptions != null ? nonListedAndComplexListedOptions.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AnnaDsbCategory {" +
				"Swaps=" + this.swaps + ", " +
				"NonListedAndComplexListedOptions=" + this.nonListedAndComplexListedOptions +
			'}';
		}
	}

	/*********************** Builder Implementation of AnnaDsbCategory  ***********************/
	class AnnaDsbCategoryBuilderImpl implements AnnaDsbCategory.AnnaDsbCategoryBuilder {
	
		protected AnnaDsbRateGroup.AnnaDsbRateGroupBuilder swaps;
		protected AnnaDsbRateGroup.AnnaDsbRateGroupBuilder nonListedAndComplexListedOptions;
		
		@Override
		@RosettaAttribute("Swaps")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("Swaps")
		public AnnaDsbRateGroup.AnnaDsbRateGroupBuilder getSwaps() {
			return swaps;
		}
		
		@Override
		public AnnaDsbRateGroup.AnnaDsbRateGroupBuilder getOrCreateSwaps() {
			AnnaDsbRateGroup.AnnaDsbRateGroupBuilder result;
			if (swaps!=null) {
				result = swaps;
			}
			else {
				result = swaps = AnnaDsbRateGroup.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("NonListedAndComplexListedOptions")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("NonListedAndComplexListedOptions")
		public AnnaDsbRateGroup.AnnaDsbRateGroupBuilder getNonListedAndComplexListedOptions() {
			return nonListedAndComplexListedOptions;
		}
		
		@Override
		public AnnaDsbRateGroup.AnnaDsbRateGroupBuilder getOrCreateNonListedAndComplexListedOptions() {
			AnnaDsbRateGroup.AnnaDsbRateGroupBuilder result;
			if (nonListedAndComplexListedOptions!=null) {
				result = nonListedAndComplexListedOptions;
			}
			else {
				result = nonListedAndComplexListedOptions = AnnaDsbRateGroup.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("Swaps")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("Swaps")
		@Override
		public AnnaDsbCategory.AnnaDsbCategoryBuilder setSwaps(AnnaDsbRateGroup _swaps) {
			this.swaps = _swaps == null ? null : _swaps.toBuilder();
			return this;
		}
		
		@RosettaAttribute("NonListedAndComplexListedOptions")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("NonListedAndComplexListedOptions")
		@Override
		public AnnaDsbCategory.AnnaDsbCategoryBuilder setNonListedAndComplexListedOptions(AnnaDsbRateGroup _nonListedAndComplexListedOptions) {
			this.nonListedAndComplexListedOptions = _nonListedAndComplexListedOptions == null ? null : _nonListedAndComplexListedOptions.toBuilder();
			return this;
		}
		
		@Override
		public AnnaDsbCategory build() {
			return new AnnaDsbCategory.AnnaDsbCategoryImpl(this);
		}
		
		@Override
		public AnnaDsbCategory.AnnaDsbCategoryBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AnnaDsbCategory.AnnaDsbCategoryBuilder prune() {
			if (swaps!=null && !swaps.prune().hasData()) swaps = null;
			if (nonListedAndComplexListedOptions!=null && !nonListedAndComplexListedOptions.prune().hasData()) nonListedAndComplexListedOptions = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getSwaps()!=null && getSwaps().hasData()) return true;
			if (getNonListedAndComplexListedOptions()!=null && getNonListedAndComplexListedOptions().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AnnaDsbCategory.AnnaDsbCategoryBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AnnaDsbCategory.AnnaDsbCategoryBuilder o = (AnnaDsbCategory.AnnaDsbCategoryBuilder) other;
			
			merger.mergeRosetta(getSwaps(), o.getSwaps(), this::setSwaps);
			merger.mergeRosetta(getNonListedAndComplexListedOptions(), o.getNonListedAndComplexListedOptions(), this::setNonListedAndComplexListedOptions);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AnnaDsbCategory _that = getType().cast(o);
		
			if (!Objects.equals(swaps, _that.getSwaps())) return false;
			if (!Objects.equals(nonListedAndComplexListedOptions, _that.getNonListedAndComplexListedOptions())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (swaps != null ? swaps.hashCode() : 0);
			_result = 31 * _result + (nonListedAndComplexListedOptions != null ? nonListedAndComplexListedOptions.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AnnaDsbCategoryBuilder {" +
				"Swaps=" + this.swaps + ", " +
				"NonListedAndComplexListedOptions=" + this.nonListedAndComplexListedOptions +
			'}';
		}
	}
}
