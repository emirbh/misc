package fpml.consolidated.fx.targets;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
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
import com.rosetta.util.ListEquals;
import fpml.consolidated.fx.targets.meta.FxTargetMeta;
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
@RosettaDataType(value="FxTarget", builder=FxTarget.FxTargetBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FxTarget", model="fpml", builder=FxTarget.FxTargetBuilderImpl.class, version="2.1.1")
public interface FxTarget extends RosettaModelObject {

	FxTargetMeta metaData = new FxTargetMeta();

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
	String getId();
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
	List<? extends FxTargetAccumulationRegion> getAccumulationRegion();
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
	FxKnockoutLevel getKnockoutLevel();
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
	FxKnockoutCount getKnockoutCount();

	/*********************** Build Methods  ***********************/
	FxTarget build();
	
	FxTarget.FxTargetBuilder toBuilder();
	
	static FxTarget.FxTargetBuilder builder() {
		return new FxTarget.FxTargetBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxTarget> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FxTarget> getType() {
		return FxTarget.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("accumulationRegion"), processor, FxTargetAccumulationRegion.class, getAccumulationRegion());
		processRosetta(path.newSubPath("knockoutLevel"), processor, FxKnockoutLevel.class, getKnockoutLevel());
		processRosetta(path.newSubPath("knockoutCount"), processor, FxKnockoutCount.class, getKnockoutCount());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxTargetBuilder extends FxTarget, RosettaModelObjectBuilder {
		FxTargetAccumulationRegion.FxTargetAccumulationRegionBuilder getOrCreateAccumulationRegion(int index);
		@Override
		List<? extends FxTargetAccumulationRegion.FxTargetAccumulationRegionBuilder> getAccumulationRegion();
		FxKnockoutLevel.FxKnockoutLevelBuilder getOrCreateKnockoutLevel();
		@Override
		FxKnockoutLevel.FxKnockoutLevelBuilder getKnockoutLevel();
		FxKnockoutCount.FxKnockoutCountBuilder getOrCreateKnockoutCount();
		@Override
		FxKnockoutCount.FxKnockoutCountBuilder getKnockoutCount();
		FxTarget.FxTargetBuilder setId(String id);
		FxTarget.FxTargetBuilder addAccumulationRegion(FxTargetAccumulationRegion accumulationRegion);
		FxTarget.FxTargetBuilder addAccumulationRegion(FxTargetAccumulationRegion accumulationRegion, int idx);
		FxTarget.FxTargetBuilder addAccumulationRegion(List<? extends FxTargetAccumulationRegion> accumulationRegion);
		FxTarget.FxTargetBuilder setAccumulationRegion(List<? extends FxTargetAccumulationRegion> accumulationRegion);
		FxTarget.FxTargetBuilder setKnockoutLevel(FxKnockoutLevel knockoutLevel);
		FxTarget.FxTargetBuilder setKnockoutCount(FxKnockoutCount knockoutCount);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("accumulationRegion"), processor, FxTargetAccumulationRegion.FxTargetAccumulationRegionBuilder.class, getAccumulationRegion());
			processRosetta(path.newSubPath("knockoutLevel"), processor, FxKnockoutLevel.FxKnockoutLevelBuilder.class, getKnockoutLevel());
			processRosetta(path.newSubPath("knockoutCount"), processor, FxKnockoutCount.FxKnockoutCountBuilder.class, getKnockoutCount());
		}
		

		FxTarget.FxTargetBuilder prune();
	}

	/*********************** Immutable Implementation of FxTarget  ***********************/
	class FxTargetImpl implements FxTarget {
		private final String id;
		private final List<? extends FxTargetAccumulationRegion> accumulationRegion;
		private final FxKnockoutLevel knockoutLevel;
		private final FxKnockoutCount knockoutCount;
		
		protected FxTargetImpl(FxTarget.FxTargetBuilder builder) {
			this.id = builder.getId();
			this.accumulationRegion = ofNullable(builder.getAccumulationRegion()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.knockoutLevel = ofNullable(builder.getKnockoutLevel()).map(f->f.build()).orElse(null);
			this.knockoutCount = ofNullable(builder.getKnockoutCount()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("accumulationRegion")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("accumulationRegion")
		public List<? extends FxTargetAccumulationRegion> getAccumulationRegion() {
			return accumulationRegion;
		}
		
		@Override
		@RosettaAttribute("knockoutLevel")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("knockoutLevel")
		public FxKnockoutLevel getKnockoutLevel() {
			return knockoutLevel;
		}
		
		@Override
		@RosettaAttribute("knockoutCount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("knockoutCount")
		public FxKnockoutCount getKnockoutCount() {
			return knockoutCount;
		}
		
		@Override
		public FxTarget build() {
			return this;
		}
		
		@Override
		public FxTarget.FxTargetBuilder toBuilder() {
			FxTarget.FxTargetBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxTarget.FxTargetBuilder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getAccumulationRegion()).ifPresent(builder::setAccumulationRegion);
			ofNullable(getKnockoutLevel()).ifPresent(builder::setKnockoutLevel);
			ofNullable(getKnockoutCount()).ifPresent(builder::setKnockoutCount);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxTarget _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!ListEquals.listEquals(accumulationRegion, _that.getAccumulationRegion())) return false;
			if (!Objects.equals(knockoutLevel, _that.getKnockoutLevel())) return false;
			if (!Objects.equals(knockoutCount, _that.getKnockoutCount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (accumulationRegion != null ? accumulationRegion.hashCode() : 0);
			_result = 31 * _result + (knockoutLevel != null ? knockoutLevel.hashCode() : 0);
			_result = 31 * _result + (knockoutCount != null ? knockoutCount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxTarget {" +
				"id=" + this.id + ", " +
				"accumulationRegion=" + this.accumulationRegion + ", " +
				"knockoutLevel=" + this.knockoutLevel + ", " +
				"knockoutCount=" + this.knockoutCount +
			'}';
		}
	}

	/*********************** Builder Implementation of FxTarget  ***********************/
	class FxTargetBuilderImpl implements FxTarget.FxTargetBuilder {
	
		protected String id;
		protected List<FxTargetAccumulationRegion.FxTargetAccumulationRegionBuilder> accumulationRegion = new ArrayList<>();
		protected FxKnockoutLevel.FxKnockoutLevelBuilder knockoutLevel;
		protected FxKnockoutCount.FxKnockoutCountBuilder knockoutCount;
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("accumulationRegion")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("accumulationRegion")
		public List<? extends FxTargetAccumulationRegion.FxTargetAccumulationRegionBuilder> getAccumulationRegion() {
			return accumulationRegion;
		}
		
		@Override
		public FxTargetAccumulationRegion.FxTargetAccumulationRegionBuilder getOrCreateAccumulationRegion(int index) {
			if (accumulationRegion==null) {
				this.accumulationRegion = new ArrayList<>();
			}
			return getIndex(accumulationRegion, index, () -> {
						FxTargetAccumulationRegion.FxTargetAccumulationRegionBuilder newAccumulationRegion = FxTargetAccumulationRegion.builder();
						return newAccumulationRegion;
					});
		}
		
		@Override
		@RosettaAttribute("knockoutLevel")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("knockoutLevel")
		public FxKnockoutLevel.FxKnockoutLevelBuilder getKnockoutLevel() {
			return knockoutLevel;
		}
		
		@Override
		public FxKnockoutLevel.FxKnockoutLevelBuilder getOrCreateKnockoutLevel() {
			FxKnockoutLevel.FxKnockoutLevelBuilder result;
			if (knockoutLevel!=null) {
				result = knockoutLevel;
			}
			else {
				result = knockoutLevel = FxKnockoutLevel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("knockoutCount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("knockoutCount")
		public FxKnockoutCount.FxKnockoutCountBuilder getKnockoutCount() {
			return knockoutCount;
		}
		
		@Override
		public FxKnockoutCount.FxKnockoutCountBuilder getOrCreateKnockoutCount() {
			FxKnockoutCount.FxKnockoutCountBuilder result;
			if (knockoutCount!=null) {
				result = knockoutCount;
			}
			else {
				result = knockoutCount = FxKnockoutCount.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public FxTarget.FxTargetBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("accumulationRegion")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("accumulationRegion")
		@Override
		public FxTarget.FxTargetBuilder addAccumulationRegion(FxTargetAccumulationRegion _accumulationRegion) {
			if (_accumulationRegion != null) {
				this.accumulationRegion.add(_accumulationRegion.toBuilder());
			}
			return this;
		}
		
		@Override
		public FxTarget.FxTargetBuilder addAccumulationRegion(FxTargetAccumulationRegion _accumulationRegion, int idx) {
			getIndex(this.accumulationRegion, idx, () -> _accumulationRegion.toBuilder());
			return this;
		}
		
		@Override
		public FxTarget.FxTargetBuilder addAccumulationRegion(List<? extends FxTargetAccumulationRegion> accumulationRegions) {
			if (accumulationRegions != null) {
				for (final FxTargetAccumulationRegion toAdd : accumulationRegions) {
					this.accumulationRegion.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("accumulationRegion")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("accumulationRegion")
		@Override
		public FxTarget.FxTargetBuilder setAccumulationRegion(List<? extends FxTargetAccumulationRegion> accumulationRegions) {
			if (accumulationRegions == null) {
				this.accumulationRegion = new ArrayList<>();
			} else {
				this.accumulationRegion = accumulationRegions.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("knockoutLevel")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("knockoutLevel")
		@Override
		public FxTarget.FxTargetBuilder setKnockoutLevel(FxKnockoutLevel _knockoutLevel) {
			this.knockoutLevel = _knockoutLevel == null ? null : _knockoutLevel.toBuilder();
			return this;
		}
		
		@RosettaAttribute("knockoutCount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("knockoutCount")
		@Override
		public FxTarget.FxTargetBuilder setKnockoutCount(FxKnockoutCount _knockoutCount) {
			this.knockoutCount = _knockoutCount == null ? null : _knockoutCount.toBuilder();
			return this;
		}
		
		@Override
		public FxTarget build() {
			return new FxTarget.FxTargetImpl(this);
		}
		
		@Override
		public FxTarget.FxTargetBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxTarget.FxTargetBuilder prune() {
			accumulationRegion = accumulationRegion.stream().filter(b->b!=null).<FxTargetAccumulationRegion.FxTargetAccumulationRegionBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (knockoutLevel!=null && !knockoutLevel.prune().hasData()) knockoutLevel = null;
			if (knockoutCount!=null && !knockoutCount.prune().hasData()) knockoutCount = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			if (getAccumulationRegion()!=null && getAccumulationRegion().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getKnockoutLevel()!=null && getKnockoutLevel().hasData()) return true;
			if (getKnockoutCount()!=null && getKnockoutCount().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxTarget.FxTargetBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxTarget.FxTargetBuilder o = (FxTarget.FxTargetBuilder) other;
			
			merger.mergeRosetta(getAccumulationRegion(), o.getAccumulationRegion(), this::getOrCreateAccumulationRegion);
			merger.mergeRosetta(getKnockoutLevel(), o.getKnockoutLevel(), this::setKnockoutLevel);
			merger.mergeRosetta(getKnockoutCount(), o.getKnockoutCount(), this::setKnockoutCount);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxTarget _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!ListEquals.listEquals(accumulationRegion, _that.getAccumulationRegion())) return false;
			if (!Objects.equals(knockoutLevel, _that.getKnockoutLevel())) return false;
			if (!Objects.equals(knockoutCount, _that.getKnockoutCount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (accumulationRegion != null ? accumulationRegion.hashCode() : 0);
			_result = 31 * _result + (knockoutLevel != null ? knockoutLevel.hashCode() : 0);
			_result = 31 * _result + (knockoutCount != null ? knockoutCount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxTargetBuilder {" +
				"id=" + this.id + ", " +
				"accumulationRegion=" + this.accumulationRegion + ", " +
				"knockoutLevel=" + this.knockoutLevel + ", " +
				"knockoutCount=" + this.knockoutCount +
			'}';
		}
	}
}
