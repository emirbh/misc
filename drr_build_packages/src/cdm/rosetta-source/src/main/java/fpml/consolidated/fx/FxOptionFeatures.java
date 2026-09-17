package fpml.consolidated.fx;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.util.ListEquals;
import fpml.consolidated.fx.meta.FxOptionFeaturesMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type describing the features that may be present in an FX option.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type describing the features that may be present in an FX option.
 *
 */
@RosettaDataType(value="FxOptionFeatures", builder=FxOptionFeatures.FxOptionFeaturesBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FxOptionFeatures", model="fpml", builder=FxOptionFeatures.FxOptionFeaturesBuilderImpl.class, version="2.1.1")
public interface FxOptionFeatures extends RosettaModelObject {

	FxOptionFeaturesMeta metaData = new FxOptionFeaturesMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	FxAsianFeature getAsian();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	List<? extends FxBarrierFeature> getBarrier();

	/*********************** Build Methods  ***********************/
	FxOptionFeatures build();
	
	FxOptionFeatures.FxOptionFeaturesBuilder toBuilder();
	
	static FxOptionFeatures.FxOptionFeaturesBuilder builder() {
		return new FxOptionFeatures.FxOptionFeaturesBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxOptionFeatures> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FxOptionFeatures> getType() {
		return FxOptionFeatures.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("asian"), processor, FxAsianFeature.class, getAsian());
		processRosetta(path.newSubPath("barrier"), processor, FxBarrierFeature.class, getBarrier());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxOptionFeaturesBuilder extends FxOptionFeatures, RosettaModelObjectBuilder {
		FxAsianFeature.FxAsianFeatureBuilder getOrCreateAsian();
		@Override
		FxAsianFeature.FxAsianFeatureBuilder getAsian();
		FxBarrierFeature.FxBarrierFeatureBuilder getOrCreateBarrier(int index);
		@Override
		List<? extends FxBarrierFeature.FxBarrierFeatureBuilder> getBarrier();
		FxOptionFeatures.FxOptionFeaturesBuilder setAsian(FxAsianFeature asian);
		FxOptionFeatures.FxOptionFeaturesBuilder addBarrier(FxBarrierFeature barrier);
		FxOptionFeatures.FxOptionFeaturesBuilder addBarrier(FxBarrierFeature barrier, int idx);
		FxOptionFeatures.FxOptionFeaturesBuilder addBarrier(List<? extends FxBarrierFeature> barrier);
		FxOptionFeatures.FxOptionFeaturesBuilder setBarrier(List<? extends FxBarrierFeature> barrier);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("asian"), processor, FxAsianFeature.FxAsianFeatureBuilder.class, getAsian());
			processRosetta(path.newSubPath("barrier"), processor, FxBarrierFeature.FxBarrierFeatureBuilder.class, getBarrier());
		}
		

		FxOptionFeatures.FxOptionFeaturesBuilder prune();
	}

	/*********************** Immutable Implementation of FxOptionFeatures  ***********************/
	class FxOptionFeaturesImpl implements FxOptionFeatures {
		private final FxAsianFeature asian;
		private final List<? extends FxBarrierFeature> barrier;
		
		protected FxOptionFeaturesImpl(FxOptionFeatures.FxOptionFeaturesBuilder builder) {
			this.asian = ofNullable(builder.getAsian()).map(f->f.build()).orElse(null);
			this.barrier = ofNullable(builder.getBarrier()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("asian")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("asian")
		public FxAsianFeature getAsian() {
			return asian;
		}
		
		@Override
		@RosettaAttribute("barrier")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("barrier")
		public List<? extends FxBarrierFeature> getBarrier() {
			return barrier;
		}
		
		@Override
		public FxOptionFeatures build() {
			return this;
		}
		
		@Override
		public FxOptionFeatures.FxOptionFeaturesBuilder toBuilder() {
			FxOptionFeatures.FxOptionFeaturesBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxOptionFeatures.FxOptionFeaturesBuilder builder) {
			ofNullable(getAsian()).ifPresent(builder::setAsian);
			ofNullable(getBarrier()).ifPresent(builder::setBarrier);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxOptionFeatures _that = getType().cast(o);
		
			if (!Objects.equals(asian, _that.getAsian())) return false;
			if (!ListEquals.listEquals(barrier, _that.getBarrier())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (asian != null ? asian.hashCode() : 0);
			_result = 31 * _result + (barrier != null ? barrier.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxOptionFeatures {" +
				"asian=" + this.asian + ", " +
				"barrier=" + this.barrier +
			'}';
		}
	}

	/*********************** Builder Implementation of FxOptionFeatures  ***********************/
	class FxOptionFeaturesBuilderImpl implements FxOptionFeatures.FxOptionFeaturesBuilder {
	
		protected FxAsianFeature.FxAsianFeatureBuilder asian;
		protected List<FxBarrierFeature.FxBarrierFeatureBuilder> barrier = new ArrayList<>();
		
		@Override
		@RosettaAttribute("asian")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("asian")
		public FxAsianFeature.FxAsianFeatureBuilder getAsian() {
			return asian;
		}
		
		@Override
		public FxAsianFeature.FxAsianFeatureBuilder getOrCreateAsian() {
			FxAsianFeature.FxAsianFeatureBuilder result;
			if (asian!=null) {
				result = asian;
			}
			else {
				result = asian = FxAsianFeature.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("barrier")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("barrier")
		public List<? extends FxBarrierFeature.FxBarrierFeatureBuilder> getBarrier() {
			return barrier;
		}
		
		@Override
		public FxBarrierFeature.FxBarrierFeatureBuilder getOrCreateBarrier(int index) {
			if (barrier==null) {
				this.barrier = new ArrayList<>();
			}
			return getIndex(barrier, index, () -> {
						FxBarrierFeature.FxBarrierFeatureBuilder newBarrier = FxBarrierFeature.builder();
						return newBarrier;
					});
		}
		
		@RosettaAttribute("asian")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("asian")
		@Override
		public FxOptionFeatures.FxOptionFeaturesBuilder setAsian(FxAsianFeature _asian) {
			this.asian = _asian == null ? null : _asian.toBuilder();
			return this;
		}
		
		@RosettaAttribute("barrier")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("barrier")
		@Override
		public FxOptionFeatures.FxOptionFeaturesBuilder addBarrier(FxBarrierFeature _barrier) {
			if (_barrier != null) {
				this.barrier.add(_barrier.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxOptionFeatures.FxOptionFeaturesBuilder addBarrier(FxBarrierFeature _barrier, int idx) {
			getIndex(this.barrier, idx, () -> _barrier.toBuilder());
			return this;
		}
		
		@Override
		public FxOptionFeatures.FxOptionFeaturesBuilder addBarrier(List<? extends FxBarrierFeature> barriers) {
			if (barriers != null) {
				for (final FxBarrierFeature toAdd : barriers) {
					this.barrier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("barrier")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("barrier")
		@Override
		public FxOptionFeatures.FxOptionFeaturesBuilder setBarrier(List<? extends FxBarrierFeature> barriers) {
			if (barriers == null) {
				this.barrier = new ArrayList<>();
			} else {
				this.barrier = barriers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public FxOptionFeatures build() {
			return new FxOptionFeatures.FxOptionFeaturesImpl(this);
		}
		
		@Override
		public FxOptionFeatures.FxOptionFeaturesBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxOptionFeatures.FxOptionFeaturesBuilder prune() {
			if (asian!=null && !asian.prune().hasData()) asian = null;
			barrier = barrier.stream().filter(b->b!=null).<FxBarrierFeature.FxBarrierFeatureBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAsian()!=null && getAsian().hasData()) return true;
			if (getBarrier()!=null && getBarrier().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxOptionFeatures.FxOptionFeaturesBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxOptionFeatures.FxOptionFeaturesBuilder o = (FxOptionFeatures.FxOptionFeaturesBuilder) other;
			
			merger.mergeRosetta(getAsian(), o.getAsian(), this::setAsian);
			merger.mergeRosetta(getBarrier(), o.getBarrier(), this::getOrCreateBarrier);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxOptionFeatures _that = getType().cast(o);
		
			if (!Objects.equals(asian, _that.getAsian())) return false;
			if (!ListEquals.listEquals(barrier, _that.getBarrier())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (asian != null ? asian.hashCode() : 0);
			_result = 31 * _result + (barrier != null ? barrier.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxOptionFeaturesBuilder {" +
				"asian=" + this.asian + ", " +
				"barrier=" + this.barrier +
			'}';
		}
	}
}
