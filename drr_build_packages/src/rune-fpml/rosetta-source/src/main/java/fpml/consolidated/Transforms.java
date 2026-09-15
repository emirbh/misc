package fpml.consolidated;

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
import fpml.consolidated.meta.TransformsMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


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
@RosettaDataType(value="Transforms", builder=Transforms.TransformsBuilderImpl.class, version="2.1.1")
@RuneDataType(value="Transforms", model="fpml", builder=Transforms.TransformsBuilderImpl.class, version="2.1.1")
public interface Transforms extends TransformsType {

	TransformsMeta metaData = new TransformsMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	Transforms build();
	
	Transforms.TransformsBuilder toBuilder();
	
	static Transforms.TransformsBuilder builder() {
		return new Transforms.TransformsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Transforms> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Transforms> getType() {
		return Transforms.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("transform"), processor, TransformType.class, getTransform());
	}
	

	/*********************** Builder Interface  ***********************/
	interface TransformsBuilder extends Transforms, TransformsType.TransformsTypeBuilder {
		@Override
		Transforms.TransformsBuilder addTransform(TransformType transform);
		@Override
		Transforms.TransformsBuilder addTransform(TransformType transform, int idx);
		@Override
		Transforms.TransformsBuilder addTransform(List<? extends TransformType> transform);
		@Override
		Transforms.TransformsBuilder setTransform(List<? extends TransformType> transform);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("transform"), processor, TransformType.TransformTypeBuilder.class, getTransform());
		}
		

		Transforms.TransformsBuilder prune();
	}

	/*********************** Immutable Implementation of Transforms  ***********************/
	class TransformsImpl extends TransformsType.TransformsTypeImpl implements Transforms {
		
		protected TransformsImpl(Transforms.TransformsBuilder builder) {
			super(builder);
		}
		
		@Override
		public Transforms build() {
			return this;
		}
		
		@Override
		public Transforms.TransformsBuilder toBuilder() {
			Transforms.TransformsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Transforms.TransformsBuilder builder) {
			super.setBuilderFields(builder);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "Transforms {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of Transforms  ***********************/
	class TransformsBuilderImpl extends TransformsType.TransformsTypeBuilderImpl implements Transforms.TransformsBuilder {
	
		
		@RosettaAttribute("transform")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("transform")
		@Override
		public Transforms.TransformsBuilder addTransform(TransformType _transform) {
			if (_transform != null) {
				this.transform.add(_transform.toBuilder());
			}
			return this;
		}
		
		@Override
		public Transforms.TransformsBuilder addTransform(TransformType _transform, int idx) {
			getIndex(this.transform, idx, () -> _transform.toBuilder());
			return this;
		}
		
		@Override
		public Transforms.TransformsBuilder addTransform(List<? extends TransformType> transforms) {
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
		public Transforms.TransformsBuilder setTransform(List<? extends TransformType> transforms) {
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
		public Transforms build() {
			return new Transforms.TransformsImpl(this);
		}
		
		@Override
		public Transforms.TransformsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Transforms.TransformsBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Transforms.TransformsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			Transforms.TransformsBuilder o = (Transforms.TransformsBuilder) other;
			
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "TransformsBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
