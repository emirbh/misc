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
import fpml.consolidated.meta.TransformMeta;
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
@RosettaDataType(value="Transform", builder=Transform.TransformBuilderImpl.class, version="2.1.1")
@RuneDataType(value="Transform", model="fpml", builder=Transform.TransformBuilderImpl.class, version="2.1.1")
public interface Transform extends TransformType {

	TransformMeta metaData = new TransformMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	Transform build();
	
	Transform.TransformBuilder toBuilder();
	
	static Transform.TransformBuilder builder() {
		return new Transform.TransformBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Transform> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Transform> getType() {
		return Transform.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("algorithm"), String.class, getAlgorithm(), this);
		processRosetta(path.newSubPath("transformTypeChoice"), processor, TransformTypeChoice.class, getTransformTypeChoice());
	}
	

	/*********************** Builder Interface  ***********************/
	interface TransformBuilder extends Transform, TransformType.TransformTypeBuilder {
		@Override
		Transform.TransformBuilder setAlgorithm(String algorithm);
		@Override
		Transform.TransformBuilder addTransformTypeChoice(TransformTypeChoice transformTypeChoice);
		@Override
		Transform.TransformBuilder addTransformTypeChoice(TransformTypeChoice transformTypeChoice, int idx);
		@Override
		Transform.TransformBuilder addTransformTypeChoice(List<? extends TransformTypeChoice> transformTypeChoice);
		@Override
		Transform.TransformBuilder setTransformTypeChoice(List<? extends TransformTypeChoice> transformTypeChoice);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("algorithm"), String.class, getAlgorithm(), this);
			processRosetta(path.newSubPath("transformTypeChoice"), processor, TransformTypeChoice.TransformTypeChoiceBuilder.class, getTransformTypeChoice());
		}
		

		Transform.TransformBuilder prune();
	}

	/*********************** Immutable Implementation of Transform  ***********************/
	class TransformImpl extends TransformType.TransformTypeImpl implements Transform {
		
		protected TransformImpl(Transform.TransformBuilder builder) {
			super(builder);
		}
		
		@Override
		public Transform build() {
			return this;
		}
		
		@Override
		public Transform.TransformBuilder toBuilder() {
			Transform.TransformBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Transform.TransformBuilder builder) {
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
			return "Transform {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of Transform  ***********************/
	class TransformBuilderImpl extends TransformType.TransformTypeBuilderImpl implements Transform.TransformBuilder {
	
		
		@RosettaAttribute("algorithm")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("algorithm")
		@Override
		public Transform.TransformBuilder setAlgorithm(String _algorithm) {
			this.algorithm = _algorithm == null ? null : _algorithm;
			return this;
		}
		
		@RosettaAttribute("transformTypeChoice")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("transformTypeChoice")
		@Override
		public Transform.TransformBuilder addTransformTypeChoice(TransformTypeChoice _transformTypeChoice) {
			if (_transformTypeChoice != null) {
				this.transformTypeChoice.add(_transformTypeChoice.toBuilder());
			}
			return this;
		}
		
		@Override
		public Transform.TransformBuilder addTransformTypeChoice(TransformTypeChoice _transformTypeChoice, int idx) {
			getIndex(this.transformTypeChoice, idx, () -> _transformTypeChoice.toBuilder());
			return this;
		}
		
		@Override
		public Transform.TransformBuilder addTransformTypeChoice(List<? extends TransformTypeChoice> transformTypeChoices) {
			if (transformTypeChoices != null) {
				for (final TransformTypeChoice toAdd : transformTypeChoices) {
					this.transformTypeChoice.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("transformTypeChoice")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("transformTypeChoice")
		@Override
		public Transform.TransformBuilder setTransformTypeChoice(List<? extends TransformTypeChoice> transformTypeChoices) {
			if (transformTypeChoices == null) {
				this.transformTypeChoice = new ArrayList<>();
			} else {
				this.transformTypeChoice = transformTypeChoices.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public Transform build() {
			return new Transform.TransformImpl(this);
		}
		
		@Override
		public Transform.TransformBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Transform.TransformBuilder prune() {
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
		public Transform.TransformBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			Transform.TransformBuilder o = (Transform.TransformBuilder) other;
			
			
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
			return "TransformBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
