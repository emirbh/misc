package fpml.consolidated;

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
import fpml.consolidated.meta.SPKIDataTypeMeta;
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
@RosettaDataType(value="SPKIDataType", builder=SPKIDataType.SPKIDataTypeBuilderImpl.class, version="2.1.1")
@RuneDataType(value="SPKIDataType", model="fpml", builder=SPKIDataType.SPKIDataTypeBuilderImpl.class, version="2.1.1")
public interface SPKIDataType extends RosettaModelObject {

	SPKIDataTypeMeta metaData = new SPKIDataTypeMeta();

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
	List<? extends SPKIDataTypeSequence> getSpkiDataTypeSequence();

	/*********************** Build Methods  ***********************/
	SPKIDataType build();
	
	SPKIDataType.SPKIDataTypeBuilder toBuilder();
	
	static SPKIDataType.SPKIDataTypeBuilder builder() {
		return new SPKIDataType.SPKIDataTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SPKIDataType> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends SPKIDataType> getType() {
		return SPKIDataType.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("spkiDataTypeSequence"), processor, SPKIDataTypeSequence.class, getSpkiDataTypeSequence());
	}
	

	/*********************** Builder Interface  ***********************/
	interface SPKIDataTypeBuilder extends SPKIDataType, RosettaModelObjectBuilder {
		SPKIDataTypeSequence.SPKIDataTypeSequenceBuilder getOrCreateSpkiDataTypeSequence(int index);
		@Override
		List<? extends SPKIDataTypeSequence.SPKIDataTypeSequenceBuilder> getSpkiDataTypeSequence();
		SPKIDataType.SPKIDataTypeBuilder addSpkiDataTypeSequence(SPKIDataTypeSequence spkiDataTypeSequence);
		SPKIDataType.SPKIDataTypeBuilder addSpkiDataTypeSequence(SPKIDataTypeSequence spkiDataTypeSequence, int idx);
		SPKIDataType.SPKIDataTypeBuilder addSpkiDataTypeSequence(List<? extends SPKIDataTypeSequence> spkiDataTypeSequence);
		SPKIDataType.SPKIDataTypeBuilder setSpkiDataTypeSequence(List<? extends SPKIDataTypeSequence> spkiDataTypeSequence);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("spkiDataTypeSequence"), processor, SPKIDataTypeSequence.SPKIDataTypeSequenceBuilder.class, getSpkiDataTypeSequence());
		}
		

		SPKIDataType.SPKIDataTypeBuilder prune();
	}

	/*********************** Immutable Implementation of SPKIDataType  ***********************/
	class SPKIDataTypeImpl implements SPKIDataType {
		private final List<? extends SPKIDataTypeSequence> spkiDataTypeSequence;
		
		protected SPKIDataTypeImpl(SPKIDataType.SPKIDataTypeBuilder builder) {
			this.spkiDataTypeSequence = ofNullable(builder.getSpkiDataTypeSequence()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("spkiDataTypeSequence")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("spkiDataTypeSequence")
		public List<? extends SPKIDataTypeSequence> getSpkiDataTypeSequence() {
			return spkiDataTypeSequence;
		}
		
		@Override
		public SPKIDataType build() {
			return this;
		}
		
		@Override
		public SPKIDataType.SPKIDataTypeBuilder toBuilder() {
			SPKIDataType.SPKIDataTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SPKIDataType.SPKIDataTypeBuilder builder) {
			ofNullable(getSpkiDataTypeSequence()).ifPresent(builder::setSpkiDataTypeSequence);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SPKIDataType _that = getType().cast(o);
		
			if (!ListEquals.listEquals(spkiDataTypeSequence, _that.getSpkiDataTypeSequence())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (spkiDataTypeSequence != null ? spkiDataTypeSequence.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SPKIDataType {" +
				"spkiDataTypeSequence=" + this.spkiDataTypeSequence +
			'}';
		}
	}

	/*********************** Builder Implementation of SPKIDataType  ***********************/
	class SPKIDataTypeBuilderImpl implements SPKIDataType.SPKIDataTypeBuilder {
	
		protected List<SPKIDataTypeSequence.SPKIDataTypeSequenceBuilder> spkiDataTypeSequence = new ArrayList<>();
		
		@Override
		@RosettaAttribute("spkiDataTypeSequence")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("spkiDataTypeSequence")
		public List<? extends SPKIDataTypeSequence.SPKIDataTypeSequenceBuilder> getSpkiDataTypeSequence() {
			return spkiDataTypeSequence;
		}
		
		@Override
		public SPKIDataTypeSequence.SPKIDataTypeSequenceBuilder getOrCreateSpkiDataTypeSequence(int index) {
			if (spkiDataTypeSequence==null) {
				this.spkiDataTypeSequence = new ArrayList<>();
			}
			return getIndex(spkiDataTypeSequence, index, () -> {
						SPKIDataTypeSequence.SPKIDataTypeSequenceBuilder newSpkiDataTypeSequence = SPKIDataTypeSequence.builder();
						return newSpkiDataTypeSequence;
					});
		}
		
		@RosettaAttribute("spkiDataTypeSequence")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("spkiDataTypeSequence")
		@Override
		public SPKIDataType.SPKIDataTypeBuilder addSpkiDataTypeSequence(SPKIDataTypeSequence _spkiDataTypeSequence) {
			if (_spkiDataTypeSequence != null) {
				this.spkiDataTypeSequence.add(_spkiDataTypeSequence.toBuilder());
			}
			return this;
		}
		
		@Override
		public SPKIDataType.SPKIDataTypeBuilder addSpkiDataTypeSequence(SPKIDataTypeSequence _spkiDataTypeSequence, int idx) {
			getIndex(this.spkiDataTypeSequence, idx, () -> _spkiDataTypeSequence.toBuilder());
			return this;
		}
		
		@Override
		public SPKIDataType.SPKIDataTypeBuilder addSpkiDataTypeSequence(List<? extends SPKIDataTypeSequence> spkiDataTypeSequences) {
			if (spkiDataTypeSequences != null) {
				for (final SPKIDataTypeSequence toAdd : spkiDataTypeSequences) {
					this.spkiDataTypeSequence.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("spkiDataTypeSequence")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("spkiDataTypeSequence")
		@Override
		public SPKIDataType.SPKIDataTypeBuilder setSpkiDataTypeSequence(List<? extends SPKIDataTypeSequence> spkiDataTypeSequences) {
			if (spkiDataTypeSequences == null) {
				this.spkiDataTypeSequence = new ArrayList<>();
			} else {
				this.spkiDataTypeSequence = spkiDataTypeSequences.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public SPKIDataType build() {
			return new SPKIDataType.SPKIDataTypeImpl(this);
		}
		
		@Override
		public SPKIDataType.SPKIDataTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SPKIDataType.SPKIDataTypeBuilder prune() {
			spkiDataTypeSequence = spkiDataTypeSequence.stream().filter(b->b!=null).<SPKIDataTypeSequence.SPKIDataTypeSequenceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getSpkiDataTypeSequence()!=null && getSpkiDataTypeSequence().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SPKIDataType.SPKIDataTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SPKIDataType.SPKIDataTypeBuilder o = (SPKIDataType.SPKIDataTypeBuilder) other;
			
			merger.mergeRosetta(getSpkiDataTypeSequence(), o.getSpkiDataTypeSequence(), this::getOrCreateSpkiDataTypeSequence);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SPKIDataType _that = getType().cast(o);
		
			if (!ListEquals.listEquals(spkiDataTypeSequence, _that.getSpkiDataTypeSequence())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (spkiDataTypeSequence != null ? spkiDataTypeSequence.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SPKIDataTypeBuilder {" +
				"spkiDataTypeSequence=" + this.spkiDataTypeSequence +
			'}';
		}
	}
}
