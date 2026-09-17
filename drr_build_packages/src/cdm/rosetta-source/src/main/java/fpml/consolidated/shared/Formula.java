package fpml.consolidated.shared;

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
import fpml.consolidated.shared.meta.FormulaMeta;
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
 * Provision A type describing a financial formula, with its description and components.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type describing a financial formula, with its description and components.
 *
 */
@RosettaDataType(value="Formula", builder=Formula.FormulaBuilderImpl.class, version="2.1.1")
@RuneDataType(value="Formula", model="fpml", builder=Formula.FormulaBuilderImpl.class, version="2.1.1")
public interface Formula extends RosettaModelObject {

	FormulaMeta metaData = new FormulaMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Text description of the formula
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Text description of the formula
	 *
	 */
	String getFormulaDescription();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision An element for containing an XML representation of the formula. Defined using xsd:any currently for flexibility in choice of language (MathML, OpenMath)
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision An element for containing an XML representation of the formula. Defined using xsd:any currently for flexibility in choice of language (MathML, OpenMath)
	 *
	 */
	fpml.consolidated.shared.Math getMath();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Elements describing the components of the formula. The name attribute points to a value used in the math element. The href attribute points to a value elsewhere in the document
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Elements describing the components of the formula. The name attribute points to a value used in the math element. The href attribute points to a value elsewhere in the document
	 *
	 */
	List<? extends FormulaComponent> getFormulaComponent();

	/*********************** Build Methods  ***********************/
	Formula build();
	
	Formula.FormulaBuilder toBuilder();
	
	static Formula.FormulaBuilder builder() {
		return new Formula.FormulaBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Formula> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Formula> getType() {
		return Formula.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("formulaDescription"), String.class, getFormulaDescription(), this);
		processRosetta(path.newSubPath("math"), processor, fpml.consolidated.shared.Math.class, getMath());
		processRosetta(path.newSubPath("formulaComponent"), processor, FormulaComponent.class, getFormulaComponent());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FormulaBuilder extends Formula, RosettaModelObjectBuilder {
		Math.MathBuilder getOrCreateMath();
		@Override
		Math.MathBuilder getMath();
		FormulaComponent.FormulaComponentBuilder getOrCreateFormulaComponent(int index);
		@Override
		List<? extends FormulaComponent.FormulaComponentBuilder> getFormulaComponent();
		Formula.FormulaBuilder setFormulaDescription(String formulaDescription);
		Formula.FormulaBuilder setMath(fpml.consolidated.shared.Math math);
		Formula.FormulaBuilder addFormulaComponent(FormulaComponent formulaComponent);
		Formula.FormulaBuilder addFormulaComponent(FormulaComponent formulaComponent, int idx);
		Formula.FormulaBuilder addFormulaComponent(List<? extends FormulaComponent> formulaComponent);
		Formula.FormulaBuilder setFormulaComponent(List<? extends FormulaComponent> formulaComponent);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("formulaDescription"), String.class, getFormulaDescription(), this);
			processRosetta(path.newSubPath("math"), processor, Math.MathBuilder.class, getMath());
			processRosetta(path.newSubPath("formulaComponent"), processor, FormulaComponent.FormulaComponentBuilder.class, getFormulaComponent());
		}
		

		Formula.FormulaBuilder prune();
	}

	/*********************** Immutable Implementation of Formula  ***********************/
	class FormulaImpl implements Formula {
		private final String formulaDescription;
		private final fpml.consolidated.shared.Math math;
		private final List<? extends FormulaComponent> formulaComponent;
		
		protected FormulaImpl(Formula.FormulaBuilder builder) {
			this.formulaDescription = builder.getFormulaDescription();
			this.math = ofNullable(builder.getMath()).map(f->f.build()).orElse(null);
			this.formulaComponent = ofNullable(builder.getFormulaComponent()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("formulaDescription")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("formulaDescription")
		public String getFormulaDescription() {
			return formulaDescription;
		}
		
		@Override
		@RosettaAttribute("math")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("math")
		public fpml.consolidated.shared.Math getMath() {
			return math;
		}
		
		@Override
		@RosettaAttribute("formulaComponent")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("formulaComponent")
		public List<? extends FormulaComponent> getFormulaComponent() {
			return formulaComponent;
		}
		
		@Override
		public Formula build() {
			return this;
		}
		
		@Override
		public Formula.FormulaBuilder toBuilder() {
			Formula.FormulaBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Formula.FormulaBuilder builder) {
			ofNullable(getFormulaDescription()).ifPresent(builder::setFormulaDescription);
			ofNullable(getMath()).ifPresent(builder::setMath);
			ofNullable(getFormulaComponent()).ifPresent(builder::setFormulaComponent);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Formula _that = getType().cast(o);
		
			if (!Objects.equals(formulaDescription, _that.getFormulaDescription())) return false;
			if (!Objects.equals(math, _that.getMath())) return false;
			if (!ListEquals.listEquals(formulaComponent, _that.getFormulaComponent())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (formulaDescription != null ? formulaDescription.hashCode() : 0);
			_result = 31 * _result + (math != null ? math.hashCode() : 0);
			_result = 31 * _result + (formulaComponent != null ? formulaComponent.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Formula {" +
				"formulaDescription=" + this.formulaDescription + ", " +
				"math=" + this.math + ", " +
				"formulaComponent=" + this.formulaComponent +
			'}';
		}
	}

	/*********************** Builder Implementation of Formula  ***********************/
	class FormulaBuilderImpl implements Formula.FormulaBuilder {
	
		protected String formulaDescription;
		protected Math.MathBuilder math;
		protected List<FormulaComponent.FormulaComponentBuilder> formulaComponent = new ArrayList<>();
		
		@Override
		@RosettaAttribute("formulaDescription")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("formulaDescription")
		public String getFormulaDescription() {
			return formulaDescription;
		}
		
		@Override
		@RosettaAttribute("math")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("math")
		public Math.MathBuilder getMath() {
			return math;
		}
		
		@Override
		public Math.MathBuilder getOrCreateMath() {
			Math.MathBuilder result;
			if (math!=null) {
				result = math;
			}
			else {
				result = math = fpml.consolidated.shared.Math.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("formulaComponent")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("formulaComponent")
		public List<? extends FormulaComponent.FormulaComponentBuilder> getFormulaComponent() {
			return formulaComponent;
		}
		
		@Override
		public FormulaComponent.FormulaComponentBuilder getOrCreateFormulaComponent(int index) {
			if (formulaComponent==null) {
				this.formulaComponent = new ArrayList<>();
			}
			return getIndex(formulaComponent, index, () -> {
						FormulaComponent.FormulaComponentBuilder newFormulaComponent = FormulaComponent.builder();
						return newFormulaComponent;
					});
		}
		
		@RosettaAttribute("formulaDescription")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("formulaDescription")
		@Override
		public Formula.FormulaBuilder setFormulaDescription(String _formulaDescription) {
			this.formulaDescription = _formulaDescription == null ? null : _formulaDescription;
			return this;
		}
		
		@RosettaAttribute("math")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("math")
		@Override
		public Formula.FormulaBuilder setMath(fpml.consolidated.shared.Math _math) {
			this.math = _math == null ? null : _math.toBuilder();
			return this;
		}
		
		@RosettaAttribute("formulaComponent")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("formulaComponent")
		@Override
		public Formula.FormulaBuilder addFormulaComponent(FormulaComponent _formulaComponent) {
			if (_formulaComponent != null) {
				this.formulaComponent.add(_formulaComponent.toBuilder());
			}
			return this;
		}
		
		@Override
		public Formula.FormulaBuilder addFormulaComponent(FormulaComponent _formulaComponent, int idx) {
			getIndex(this.formulaComponent, idx, () -> _formulaComponent.toBuilder());
			return this;
		}
		
		@Override
		public Formula.FormulaBuilder addFormulaComponent(List<? extends FormulaComponent> formulaComponents) {
			if (formulaComponents != null) {
				for (final FormulaComponent toAdd : formulaComponents) {
					this.formulaComponent.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("formulaComponent")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("formulaComponent")
		@Override
		public Formula.FormulaBuilder setFormulaComponent(List<? extends FormulaComponent> formulaComponents) {
			if (formulaComponents == null) {
				this.formulaComponent = new ArrayList<>();
			} else {
				this.formulaComponent = formulaComponents.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public Formula build() {
			return new Formula.FormulaImpl(this);
		}
		
		@Override
		public Formula.FormulaBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Formula.FormulaBuilder prune() {
			if (math!=null && !math.prune().hasData()) math = null;
			formulaComponent = formulaComponent.stream().filter(b->b!=null).<FormulaComponent.FormulaComponentBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getFormulaDescription()!=null) return true;
			if (getMath()!=null && getMath().hasData()) return true;
			if (getFormulaComponent()!=null && getFormulaComponent().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Formula.FormulaBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Formula.FormulaBuilder o = (Formula.FormulaBuilder) other;
			
			merger.mergeRosetta(getMath(), o.getMath(), this::setMath);
			merger.mergeRosetta(getFormulaComponent(), o.getFormulaComponent(), this::getOrCreateFormulaComponent);
			
			merger.mergeBasic(getFormulaDescription(), o.getFormulaDescription(), this::setFormulaDescription);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Formula _that = getType().cast(o);
		
			if (!Objects.equals(formulaDescription, _that.getFormulaDescription())) return false;
			if (!Objects.equals(math, _that.getMath())) return false;
			if (!ListEquals.listEquals(formulaComponent, _that.getFormulaComponent())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (formulaDescription != null ? formulaDescription.hashCode() : 0);
			_result = 31 * _result + (math != null ? math.hashCode() : 0);
			_result = 31 * _result + (formulaComponent != null ? formulaComponent.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FormulaBuilder {" +
				"formulaDescription=" + this.formulaDescription + ", " +
				"math=" + this.math + ", " +
				"formulaComponent=" + this.formulaComponent +
			'}';
		}
	}
}
