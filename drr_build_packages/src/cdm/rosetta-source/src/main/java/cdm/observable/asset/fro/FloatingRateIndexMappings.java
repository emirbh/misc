package cdm.observable.asset.fro;

import cdm.observable.asset.fro.meta.FloatingRateIndexMappingsMeta;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * This type defines mappings between FROs in different definitional versions.
 * @version 6.23.0
 */
@RosettaDataType(value="FloatingRateIndexMappings", builder=FloatingRateIndexMappings.FloatingRateIndexMappingsBuilderImpl.class, version="6.23.0")
@RuneDataType(value="FloatingRateIndexMappings", model="cdm", builder=FloatingRateIndexMappings.FloatingRateIndexMappingsBuilderImpl.class, version="6.23.0")
public interface FloatingRateIndexMappings extends RosettaModelObject {

	FloatingRateIndexMappingsMeta metaData = new FloatingRateIndexMappingsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The successor FRO that this index maps to.
	 */
	FloatingRateIndexMap getMapsTo();
	/**
	 * The predecessor FRO(s) that this index maps to.
	 */
	List<? extends FloatingRateIndexMap> getMapsFrom();

	/*********************** Build Methods  ***********************/
	FloatingRateIndexMappings build();
	
	FloatingRateIndexMappings.FloatingRateIndexMappingsBuilder toBuilder();
	
	static FloatingRateIndexMappings.FloatingRateIndexMappingsBuilder builder() {
		return new FloatingRateIndexMappings.FloatingRateIndexMappingsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FloatingRateIndexMappings> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FloatingRateIndexMappings> getType() {
		return FloatingRateIndexMappings.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("mapsTo"), processor, FloatingRateIndexMap.class, getMapsTo());
		processRosetta(path.newSubPath("mapsFrom"), processor, FloatingRateIndexMap.class, getMapsFrom());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FloatingRateIndexMappingsBuilder extends FloatingRateIndexMappings, RosettaModelObjectBuilder {
		FloatingRateIndexMap.FloatingRateIndexMapBuilder getOrCreateMapsTo();
		@Override
		FloatingRateIndexMap.FloatingRateIndexMapBuilder getMapsTo();
		FloatingRateIndexMap.FloatingRateIndexMapBuilder getOrCreateMapsFrom(int index);
		@Override
		List<? extends FloatingRateIndexMap.FloatingRateIndexMapBuilder> getMapsFrom();
		FloatingRateIndexMappings.FloatingRateIndexMappingsBuilder setMapsTo(FloatingRateIndexMap mapsTo);
		FloatingRateIndexMappings.FloatingRateIndexMappingsBuilder addMapsFrom(FloatingRateIndexMap mapsFrom);
		FloatingRateIndexMappings.FloatingRateIndexMappingsBuilder addMapsFrom(FloatingRateIndexMap mapsFrom, int idx);
		FloatingRateIndexMappings.FloatingRateIndexMappingsBuilder addMapsFrom(List<? extends FloatingRateIndexMap> mapsFrom);
		FloatingRateIndexMappings.FloatingRateIndexMappingsBuilder setMapsFrom(List<? extends FloatingRateIndexMap> mapsFrom);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("mapsTo"), processor, FloatingRateIndexMap.FloatingRateIndexMapBuilder.class, getMapsTo());
			processRosetta(path.newSubPath("mapsFrom"), processor, FloatingRateIndexMap.FloatingRateIndexMapBuilder.class, getMapsFrom());
		}
		

		FloatingRateIndexMappings.FloatingRateIndexMappingsBuilder prune();
	}

	/*********************** Immutable Implementation of FloatingRateIndexMappings  ***********************/
	class FloatingRateIndexMappingsImpl implements FloatingRateIndexMappings {
		private final FloatingRateIndexMap mapsTo;
		private final List<? extends FloatingRateIndexMap> mapsFrom;
		
		protected FloatingRateIndexMappingsImpl(FloatingRateIndexMappings.FloatingRateIndexMappingsBuilder builder) {
			this.mapsTo = ofNullable(builder.getMapsTo()).map(f->f.build()).orElse(null);
			this.mapsFrom = ofNullable(builder.getMapsFrom()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("mapsTo")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("mapsTo")
		public FloatingRateIndexMap getMapsTo() {
			return mapsTo;
		}
		
		@Override
		@RosettaAttribute("mapsFrom")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("mapsFrom")
		public List<? extends FloatingRateIndexMap> getMapsFrom() {
			return mapsFrom;
		}
		
		@Override
		public FloatingRateIndexMappings build() {
			return this;
		}
		
		@Override
		public FloatingRateIndexMappings.FloatingRateIndexMappingsBuilder toBuilder() {
			FloatingRateIndexMappings.FloatingRateIndexMappingsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FloatingRateIndexMappings.FloatingRateIndexMappingsBuilder builder) {
			ofNullable(getMapsTo()).ifPresent(builder::setMapsTo);
			ofNullable(getMapsFrom()).ifPresent(builder::setMapsFrom);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FloatingRateIndexMappings _that = getType().cast(o);
		
			if (!Objects.equals(mapsTo, _that.getMapsTo())) return false;
			if (!ListEquals.listEquals(mapsFrom, _that.getMapsFrom())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (mapsTo != null ? mapsTo.hashCode() : 0);
			_result = 31 * _result + (mapsFrom != null ? mapsFrom.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FloatingRateIndexMappings {" +
				"mapsTo=" + this.mapsTo + ", " +
				"mapsFrom=" + this.mapsFrom +
			'}';
		}
	}

	/*********************** Builder Implementation of FloatingRateIndexMappings  ***********************/
	class FloatingRateIndexMappingsBuilderImpl implements FloatingRateIndexMappings.FloatingRateIndexMappingsBuilder {
	
		protected FloatingRateIndexMap.FloatingRateIndexMapBuilder mapsTo;
		protected List<FloatingRateIndexMap.FloatingRateIndexMapBuilder> mapsFrom = new ArrayList<>();
		
		@Override
		@RosettaAttribute("mapsTo")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("mapsTo")
		public FloatingRateIndexMap.FloatingRateIndexMapBuilder getMapsTo() {
			return mapsTo;
		}
		
		@Override
		public FloatingRateIndexMap.FloatingRateIndexMapBuilder getOrCreateMapsTo() {
			FloatingRateIndexMap.FloatingRateIndexMapBuilder result;
			if (mapsTo!=null) {
				result = mapsTo;
			}
			else {
				result = mapsTo = FloatingRateIndexMap.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("mapsFrom")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("mapsFrom")
		public List<? extends FloatingRateIndexMap.FloatingRateIndexMapBuilder> getMapsFrom() {
			return mapsFrom;
		}
		
		@Override
		public FloatingRateIndexMap.FloatingRateIndexMapBuilder getOrCreateMapsFrom(int index) {
			if (mapsFrom==null) {
				this.mapsFrom = new ArrayList<>();
			}
			return getIndex(mapsFrom, index, () -> {
						FloatingRateIndexMap.FloatingRateIndexMapBuilder newMapsFrom = FloatingRateIndexMap.builder();
						return newMapsFrom;
					});
		}
		
		@RosettaAttribute("mapsTo")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("mapsTo")
		@Override
		public FloatingRateIndexMappings.FloatingRateIndexMappingsBuilder setMapsTo(FloatingRateIndexMap _mapsTo) {
			this.mapsTo = _mapsTo == null ? null : _mapsTo.toBuilder();
			return this;
		}
		
		@RosettaAttribute("mapsFrom")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("mapsFrom")
		@Override
		public FloatingRateIndexMappings.FloatingRateIndexMappingsBuilder addMapsFrom(FloatingRateIndexMap _mapsFrom) {
			if (_mapsFrom != null) {
				this.mapsFrom.add(_mapsFrom.toBuilder());
			}
			return this;
		}
		
		@Override
		public FloatingRateIndexMappings.FloatingRateIndexMappingsBuilder addMapsFrom(FloatingRateIndexMap _mapsFrom, int idx) {
			getIndex(this.mapsFrom, idx, () -> _mapsFrom.toBuilder());
			return this;
		}
		
		@Override
		public FloatingRateIndexMappings.FloatingRateIndexMappingsBuilder addMapsFrom(List<? extends FloatingRateIndexMap> mapsFroms) {
			if (mapsFroms != null) {
				for (final FloatingRateIndexMap toAdd : mapsFroms) {
					this.mapsFrom.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("mapsFrom")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("mapsFrom")
		@Override
		public FloatingRateIndexMappings.FloatingRateIndexMappingsBuilder setMapsFrom(List<? extends FloatingRateIndexMap> mapsFroms) {
			if (mapsFroms == null) {
				this.mapsFrom = new ArrayList<>();
			} else {
				this.mapsFrom = mapsFroms.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public FloatingRateIndexMappings build() {
			return new FloatingRateIndexMappings.FloatingRateIndexMappingsImpl(this);
		}
		
		@Override
		public FloatingRateIndexMappings.FloatingRateIndexMappingsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FloatingRateIndexMappings.FloatingRateIndexMappingsBuilder prune() {
			if (mapsTo!=null && !mapsTo.prune().hasData()) mapsTo = null;
			mapsFrom = mapsFrom.stream().filter(b->b!=null).<FloatingRateIndexMap.FloatingRateIndexMapBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getMapsTo()!=null && getMapsTo().hasData()) return true;
			if (getMapsFrom()!=null && getMapsFrom().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FloatingRateIndexMappings.FloatingRateIndexMappingsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FloatingRateIndexMappings.FloatingRateIndexMappingsBuilder o = (FloatingRateIndexMappings.FloatingRateIndexMappingsBuilder) other;
			
			merger.mergeRosetta(getMapsTo(), o.getMapsTo(), this::setMapsTo);
			merger.mergeRosetta(getMapsFrom(), o.getMapsFrom(), this::getOrCreateMapsFrom);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FloatingRateIndexMappings _that = getType().cast(o);
		
			if (!Objects.equals(mapsTo, _that.getMapsTo())) return false;
			if (!ListEquals.listEquals(mapsFrom, _that.getMapsFrom())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (mapsTo != null ? mapsTo.hashCode() : 0);
			_result = 31 * _result + (mapsFrom != null ? mapsFrom.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FloatingRateIndexMappingsBuilder {" +
				"mapsTo=" + this.mapsTo + ", " +
				"mapsFrom=" + this.mapsFrom +
			'}';
		}
	}
}
