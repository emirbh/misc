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
import fpml.consolidated.meta.TransformsTypeMeta;
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
@RosettaDataType(value="TransformsType", builder=TransformsType.TransformsTypeBuilderImpl.class, version="2.1.1")
@RuneDataType(value="TransformsType", model="fpml", builder=TransformsType.TransformsTypeBuilderImpl.class, version="2.1.1")
public interface TransformsType extends RosettaModelObject {

	TransformsTypeMeta metaData = new TransformsTypeMeta();

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
	List<? extends TransformType> getTransform();

	/*********************** Build Methods  ***********************/
	TransformsType build();
	
	TransformsType.TransformsTypeBuilder toBuilder();
	
	static TransformsType.TransformsTypeBuilder builder() {
		return new TransformsType.TransformsTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TransformsType> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends TransformsType> getType() {
		return TransformsType.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("transform"), processor, TransformType.class, getTransform());
	}
	

	/*********************** Builder Interface  ***********************/
	interface TransformsTypeBuilder extends TransformsType, RosettaModelObjectBuilder {
		TransformType.TransformTypeBuilder getOrCreateTransform(int index);
		@Override
		List<? extends TransformType.TransformTypeBuilder> getTransform();
		TransformsType.TransformsTypeBuilder addTransform(TransformType transform);
		TransformsType.TransformsTypeBuilder addTransform(TransformType transform, int idx);
		TransformsType.TransformsTypeBuilder addTransform(List<? extends TransformType> transform);
		TransformsType.TransformsTypeBuilder setTransform(List<? extends TransformType> transform);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("transform"), processor, TransformType.TransformTypeBuilder.class, getTransform());
		}
		

		TransformsType.TransformsTypeBuilder prune();
	}

	/*********************** Immutable Implementation of TransformsType  ***********************/
	class TransformsTypeImpl implements TransformsType {
		private final List<? extends TransformType> transform;
		
		protected TransformsTypeImpl(TransformsType.TransformsTypeBuilder builder) {
			this.transform = ofNullable(builder.getTransform()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("transform")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("transform")
		public List<? extends TransformType> getTransform() {
			return transform;
		}
		
		@Override
		public TransformsType build() {
			return this;
		}
		
		@Override
		public TransformsType.TransformsTypeBuilder toBuilder() {
			TransformsType.TransformsTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TransformsType.TransformsTypeBuilder builder) {
			ofNullable(getTransform()).ifPresent(builder::setTransform);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TransformsType _that = getType().cast(o);
		
			if (!ListEquals.listEquals(transform, _that.getTransform())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (transform != null ? transform.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TransformsType {" +
				"transform=" + this.transform +
			'}';
		}
	}

	/*********************** Builder Implementation of TransformsType  ***********************/
	class TransformsTypeBuilderImpl implements TransformsType.TransformsTypeBuilder {
	
		protected List<TransformType.TransformTypeBuilder> transform = new ArrayList<>();
		
		@Override
		@RosettaAttribute("transform")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("transform")
		public List<? extends TransformType.TransformTypeBuilder> getTransform() {
			return transform;
		}
		
		@Override
		public TransformType.TransformTypeBuilder getOrCreateTransform(int index) {
			if (transform==null) {
				this.transform = new ArrayList<>();
			}
			return getIndex(transform, index, () -> {
						TransformType.TransformTypeBuilder newTransform = TransformType.builder();
						return newTransform;
					});
		}
		
		@RosettaAttribute("transform")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("transform")
		@Override
		public TransformsType.TransformsTypeBuilder addTransform(TransformType _transform) {
			if (_transform != null) {
				this.transform.add(_transform.toBuilder());
			}
			return this;
		}
		
		@Override
		public TransformsType.TransformsTypeBuilder addTransform(TransformType _transform, int idx) {
			getIndex(this.transform, idx, () -> _transform.toBuilder());
			return this;
		}
		
		@Override
		public TransformsType.TransformsTypeBuilder addTransform(List<? extends TransformType> transforms) {
			if (transforms != null) {
				for (final TransformType toAdd : transforms) {
					this.transform.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("transform")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("transform")
		@Override
		public TransformsType.TransformsTypeBuilder setTransform(List<? extends TransformType> transforms) {
			if (transforms == null) {
				this.transform = new ArrayList<>();
			} else {
				this.transform = transforms.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public TransformsType build() {
			return new TransformsType.TransformsTypeImpl(this);
		}
		
		@Override
		public TransformsType.TransformsTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TransformsType.TransformsTypeBuilder prune() {
			transform = transform.stream().filter(b->b!=null).<TransformType.TransformTypeBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getTransform()!=null && getTransform().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TransformsType.TransformsTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TransformsType.TransformsTypeBuilder o = (TransformsType.TransformsTypeBuilder) other;
			
			merger.mergeRosetta(getTransform(), o.getTransform(), this::getOrCreateTransform);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TransformsType _that = getType().cast(o);
		
			if (!ListEquals.listEquals(transform, _that.getTransform())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (transform != null ? transform.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TransformsTypeBuilder {" +
				"transform=" + this.transform +
			'}';
		}
	}
}
