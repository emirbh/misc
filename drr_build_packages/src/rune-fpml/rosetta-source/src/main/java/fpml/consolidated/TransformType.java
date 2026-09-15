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
import fpml.consolidated.meta.TransformTypeMeta;
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
@RosettaDataType(value="TransformType", builder=TransformType.TransformTypeBuilderImpl.class, version="2.1.1")
@RuneDataType(value="TransformType", model="fpml", builder=TransformType.TransformTypeBuilderImpl.class, version="2.1.1")
public interface TransformType extends RosettaModelObject {

	TransformTypeMeta metaData = new TransformTypeMeta();

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
	String getAlgorithm();
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
	List<? extends TransformTypeChoice> getTransformTypeChoice();

	/*********************** Build Methods  ***********************/
	TransformType build();
	
	TransformType.TransformTypeBuilder toBuilder();
	
	static TransformType.TransformTypeBuilder builder() {
		return new TransformType.TransformTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TransformType> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends TransformType> getType() {
		return TransformType.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("algorithm"), String.class, getAlgorithm(), this);
		processRosetta(path.newSubPath("transformTypeChoice"), processor, TransformTypeChoice.class, getTransformTypeChoice());
	}
	

	/*********************** Builder Interface  ***********************/
	interface TransformTypeBuilder extends TransformType, RosettaModelObjectBuilder {
		TransformTypeChoice.TransformTypeChoiceBuilder getOrCreateTransformTypeChoice(int index);
		@Override
		List<? extends TransformTypeChoice.TransformTypeChoiceBuilder> getTransformTypeChoice();
		TransformType.TransformTypeBuilder setAlgorithm(String algorithm);
		TransformType.TransformTypeBuilder addTransformTypeChoice(TransformTypeChoice transformTypeChoice);
		TransformType.TransformTypeBuilder addTransformTypeChoice(TransformTypeChoice transformTypeChoice, int idx);
		TransformType.TransformTypeBuilder addTransformTypeChoice(List<? extends TransformTypeChoice> transformTypeChoice);
		TransformType.TransformTypeBuilder setTransformTypeChoice(List<? extends TransformTypeChoice> transformTypeChoice);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("algorithm"), String.class, getAlgorithm(), this);
			processRosetta(path.newSubPath("transformTypeChoice"), processor, TransformTypeChoice.TransformTypeChoiceBuilder.class, getTransformTypeChoice());
		}
		

		TransformType.TransformTypeBuilder prune();
	}

	/*********************** Immutable Implementation of TransformType  ***********************/
	class TransformTypeImpl implements TransformType {
		private final String algorithm;
		private final List<? extends TransformTypeChoice> transformTypeChoice;
		
		protected TransformTypeImpl(TransformType.TransformTypeBuilder builder) {
			this.algorithm = builder.getAlgorithm();
			this.transformTypeChoice = ofNullable(builder.getTransformTypeChoice()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("algorithm")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("algorithm")
		public String getAlgorithm() {
			return algorithm;
		}
		
		@Override
		@RosettaAttribute("transformTypeChoice")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("transformTypeChoice")
		public List<? extends TransformTypeChoice> getTransformTypeChoice() {
			return transformTypeChoice;
		}
		
		@Override
		public TransformType build() {
			return this;
		}
		
		@Override
		public TransformType.TransformTypeBuilder toBuilder() {
			TransformType.TransformTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TransformType.TransformTypeBuilder builder) {
			ofNullable(getAlgorithm()).ifPresent(builder::setAlgorithm);
			ofNullable(getTransformTypeChoice()).ifPresent(builder::setTransformTypeChoice);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TransformType _that = getType().cast(o);
		
			if (!Objects.equals(algorithm, _that.getAlgorithm())) return false;
			if (!ListEquals.listEquals(transformTypeChoice, _that.getTransformTypeChoice())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (algorithm != null ? algorithm.hashCode() : 0);
			_result = 31 * _result + (transformTypeChoice != null ? transformTypeChoice.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TransformType {" +
				"algorithm=" + this.algorithm + ", " +
				"transformTypeChoice=" + this.transformTypeChoice +
			'}';
		}
	}

	/*********************** Builder Implementation of TransformType  ***********************/
	class TransformTypeBuilderImpl implements TransformType.TransformTypeBuilder {
	
		protected String algorithm;
		protected List<TransformTypeChoice.TransformTypeChoiceBuilder> transformTypeChoice = new ArrayList<>();
		
		@Override
		@RosettaAttribute("algorithm")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("algorithm")
		public String getAlgorithm() {
			return algorithm;
		}
		
		@Override
		@RosettaAttribute("transformTypeChoice")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("transformTypeChoice")
		public List<? extends TransformTypeChoice.TransformTypeChoiceBuilder> getTransformTypeChoice() {
			return transformTypeChoice;
		}
		
		@Override
		public TransformTypeChoice.TransformTypeChoiceBuilder getOrCreateTransformTypeChoice(int index) {
			if (transformTypeChoice==null) {
				this.transformTypeChoice = new ArrayList<>();
			}
			return getIndex(transformTypeChoice, index, () -> {
						TransformTypeChoice.TransformTypeChoiceBuilder newTransformTypeChoice = TransformTypeChoice.builder();
						return newTransformTypeChoice;
					});
		}
		
		@RosettaAttribute("algorithm")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("algorithm")
		@Override
		public TransformType.TransformTypeBuilder setAlgorithm(String _algorithm) {
			this.algorithm = _algorithm == null ? null : _algorithm;
			return this;
		}
		
		@RosettaAttribute("transformTypeChoice")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("transformTypeChoice")
		@Override
		public TransformType.TransformTypeBuilder addTransformTypeChoice(TransformTypeChoice _transformTypeChoice) {
			if (_transformTypeChoice != null) {
				this.transformTypeChoice.add(_transformTypeChoice.toBuilder());
			}
			return this;
		}
		
		@Override
		public TransformType.TransformTypeBuilder addTransformTypeChoice(TransformTypeChoice _transformTypeChoice, int idx) {
			getIndex(this.transformTypeChoice, idx, () -> _transformTypeChoice.toBuilder());
			return this;
		}
		
		@Override
		public TransformType.TransformTypeBuilder addTransformTypeChoice(List<? extends TransformTypeChoice> transformTypeChoices) {
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
		public TransformType.TransformTypeBuilder setTransformTypeChoice(List<? extends TransformTypeChoice> transformTypeChoices) {
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
		public TransformType build() {
			return new TransformType.TransformTypeImpl(this);
		}
		
		@Override
		public TransformType.TransformTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TransformType.TransformTypeBuilder prune() {
			transformTypeChoice = transformTypeChoice.stream().filter(b->b!=null).<TransformTypeChoice.TransformTypeChoiceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAlgorithm()!=null) return true;
			if (getTransformTypeChoice()!=null && getTransformTypeChoice().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TransformType.TransformTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TransformType.TransformTypeBuilder o = (TransformType.TransformTypeBuilder) other;
			
			merger.mergeRosetta(getTransformTypeChoice(), o.getTransformTypeChoice(), this::getOrCreateTransformTypeChoice);
			
			merger.mergeBasic(getAlgorithm(), o.getAlgorithm(), this::setAlgorithm);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TransformType _that = getType().cast(o);
		
			if (!Objects.equals(algorithm, _that.getAlgorithm())) return false;
			if (!ListEquals.listEquals(transformTypeChoice, _that.getTransformTypeChoice())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (algorithm != null ? algorithm.hashCode() : 0);
			_result = 31 * _result + (transformTypeChoice != null ? transformTypeChoice.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TransformTypeBuilder {" +
				"algorithm=" + this.algorithm + ", " +
				"transformTypeChoice=" + this.transformTypeChoice +
			'}';
		}
	}
}
