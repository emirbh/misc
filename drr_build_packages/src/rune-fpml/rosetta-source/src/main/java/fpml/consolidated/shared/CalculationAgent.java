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
import fpml.consolidated.fpmlenum.CalculationAgentPartyEnum;
import fpml.consolidated.shared.meta.CalculationAgentMeta;
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
 * Provision A type defining the ISDA calculation agent responsible for performing duties as defined in the applicable product definitions.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type defining the ISDA calculation agent responsible for performing duties as defined in the applicable product definitions.
 *
 */
@RosettaDataType(value="CalculationAgent", builder=CalculationAgent.CalculationAgentBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CalculationAgent", model="fpml", builder=CalculationAgent.CalculationAgentBuilderImpl.class, version="2.1.1")
public interface CalculationAgent extends RosettaModelObject {

	CalculationAgentMeta metaData = new CalculationAgentMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A pointer style reference to a party identifier defined elsewhere in the document. The party referenced is the ISDA Calculation Agent for the trade. If more than one party is referenced then the parties are assumed to be co-calculation agents, i.e. they have joint responsibility.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A pointer style reference to a party identifier defined elsewhere in the document. The party referenced is the ISDA Calculation Agent for the trade. If more than one party is referenced then the parties are assumed to be co-calculation agents, i.e. they have joint responsibility.
	 *
	 */
	List<? extends PartyReference> getCalculationAgentPartyReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The ISDA calculation agent responsible for performing duties as defined in the applicable product definitions. For example, the Calculation Agent may be defined as being the Non-exercising Party.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The ISDA calculation agent responsible for performing duties as defined in the applicable product definitions. For example, the Calculation Agent may be defined as being the Non-exercising Party.
	 *
	 */
	CalculationAgentPartyEnum getCalculationAgentParty();

	/*********************** Build Methods  ***********************/
	CalculationAgent build();
	
	CalculationAgent.CalculationAgentBuilder toBuilder();
	
	static CalculationAgent.CalculationAgentBuilder builder() {
		return new CalculationAgent.CalculationAgentBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CalculationAgent> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CalculationAgent> getType() {
		return CalculationAgent.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("calculationAgentPartyReference"), processor, PartyReference.class, getCalculationAgentPartyReference());
		processor.processBasic(path.newSubPath("calculationAgentParty"), CalculationAgentPartyEnum.class, getCalculationAgentParty(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CalculationAgentBuilder extends CalculationAgent, RosettaModelObjectBuilder {
		PartyReference.PartyReferenceBuilder getOrCreateCalculationAgentPartyReference(int index);
		@Override
		List<? extends PartyReference.PartyReferenceBuilder> getCalculationAgentPartyReference();
		CalculationAgent.CalculationAgentBuilder addCalculationAgentPartyReference(PartyReference calculationAgentPartyReference);
		CalculationAgent.CalculationAgentBuilder addCalculationAgentPartyReference(PartyReference calculationAgentPartyReference, int idx);
		CalculationAgent.CalculationAgentBuilder addCalculationAgentPartyReference(List<? extends PartyReference> calculationAgentPartyReference);
		CalculationAgent.CalculationAgentBuilder setCalculationAgentPartyReference(List<? extends PartyReference> calculationAgentPartyReference);
		CalculationAgent.CalculationAgentBuilder setCalculationAgentParty(CalculationAgentPartyEnum calculationAgentParty);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("calculationAgentPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getCalculationAgentPartyReference());
			processor.processBasic(path.newSubPath("calculationAgentParty"), CalculationAgentPartyEnum.class, getCalculationAgentParty(), this);
		}
		

		CalculationAgent.CalculationAgentBuilder prune();
	}

	/*********************** Immutable Implementation of CalculationAgent  ***********************/
	class CalculationAgentImpl implements CalculationAgent {
		private final List<? extends PartyReference> calculationAgentPartyReference;
		private final CalculationAgentPartyEnum calculationAgentParty;
		
		protected CalculationAgentImpl(CalculationAgent.CalculationAgentBuilder builder) {
			this.calculationAgentPartyReference = ofNullable(builder.getCalculationAgentPartyReference()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.calculationAgentParty = builder.getCalculationAgentParty();
		}
		
		@Override
		@RosettaAttribute("calculationAgentPartyReference")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("calculationAgentPartyReference")
		public List<? extends PartyReference> getCalculationAgentPartyReference() {
			return calculationAgentPartyReference;
		}
		
		@Override
		@RosettaAttribute("calculationAgentParty")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculationAgentParty")
		public CalculationAgentPartyEnum getCalculationAgentParty() {
			return calculationAgentParty;
		}
		
		@Override
		public CalculationAgent build() {
			return this;
		}
		
		@Override
		public CalculationAgent.CalculationAgentBuilder toBuilder() {
			CalculationAgent.CalculationAgentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CalculationAgent.CalculationAgentBuilder builder) {
			ofNullable(getCalculationAgentPartyReference()).ifPresent(builder::setCalculationAgentPartyReference);
			ofNullable(getCalculationAgentParty()).ifPresent(builder::setCalculationAgentParty);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CalculationAgent _that = getType().cast(o);
		
			if (!ListEquals.listEquals(calculationAgentPartyReference, _that.getCalculationAgentPartyReference())) return false;
			if (!Objects.equals(calculationAgentParty, _that.getCalculationAgentParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (calculationAgentPartyReference != null ? calculationAgentPartyReference.hashCode() : 0);
			_result = 31 * _result + (calculationAgentParty != null ? calculationAgentParty.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CalculationAgent {" +
				"calculationAgentPartyReference=" + this.calculationAgentPartyReference + ", " +
				"calculationAgentParty=" + this.calculationAgentParty +
			'}';
		}
	}

	/*********************** Builder Implementation of CalculationAgent  ***********************/
	class CalculationAgentBuilderImpl implements CalculationAgent.CalculationAgentBuilder {
	
		protected List<PartyReference.PartyReferenceBuilder> calculationAgentPartyReference = new ArrayList<>();
		protected CalculationAgentPartyEnum calculationAgentParty;
		
		@Override
		@RosettaAttribute("calculationAgentPartyReference")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("calculationAgentPartyReference")
		public List<? extends PartyReference.PartyReferenceBuilder> getCalculationAgentPartyReference() {
			return calculationAgentPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateCalculationAgentPartyReference(int index) {
			if (calculationAgentPartyReference==null) {
				this.calculationAgentPartyReference = new ArrayList<>();
			}
			return getIndex(calculationAgentPartyReference, index, () -> {
						PartyReference.PartyReferenceBuilder newCalculationAgentPartyReference = PartyReference.builder();
						return newCalculationAgentPartyReference;
					});
		}
		
		@Override
		@RosettaAttribute("calculationAgentParty")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculationAgentParty")
		public CalculationAgentPartyEnum getCalculationAgentParty() {
			return calculationAgentParty;
		}
		
		@RosettaAttribute("calculationAgentPartyReference")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("calculationAgentPartyReference")
		@Override
		public CalculationAgent.CalculationAgentBuilder addCalculationAgentPartyReference(PartyReference _calculationAgentPartyReference) {
			if (_calculationAgentPartyReference != null) {
				this.calculationAgentPartyReference.add(_calculationAgentPartyReference.toBuilder());
			}
			return this;
		}
		
		@Override
		public CalculationAgent.CalculationAgentBuilder addCalculationAgentPartyReference(PartyReference _calculationAgentPartyReference, int idx) {
			getIndex(this.calculationAgentPartyReference, idx, () -> _calculationAgentPartyReference.toBuilder());
			return this;
		}
		
		@Override
		public CalculationAgent.CalculationAgentBuilder addCalculationAgentPartyReference(List<? extends PartyReference> calculationAgentPartyReferences) {
			if (calculationAgentPartyReferences != null) {
				for (final PartyReference toAdd : calculationAgentPartyReferences) {
					this.calculationAgentPartyReference.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("calculationAgentPartyReference")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("calculationAgentPartyReference")
		@Override
		public CalculationAgent.CalculationAgentBuilder setCalculationAgentPartyReference(List<? extends PartyReference> calculationAgentPartyReferences) {
			if (calculationAgentPartyReferences == null) {
				this.calculationAgentPartyReference = new ArrayList<>();
			} else {
				this.calculationAgentPartyReference = calculationAgentPartyReferences.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("calculationAgentParty")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("calculationAgentParty")
		@Override
		public CalculationAgent.CalculationAgentBuilder setCalculationAgentParty(CalculationAgentPartyEnum _calculationAgentParty) {
			this.calculationAgentParty = _calculationAgentParty == null ? null : _calculationAgentParty;
			return this;
		}
		
		@Override
		public CalculationAgent build() {
			return new CalculationAgent.CalculationAgentImpl(this);
		}
		
		@Override
		public CalculationAgent.CalculationAgentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CalculationAgent.CalculationAgentBuilder prune() {
			calculationAgentPartyReference = calculationAgentPartyReference.stream().filter(b->b!=null).<PartyReference.PartyReferenceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCalculationAgentPartyReference()!=null && getCalculationAgentPartyReference().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getCalculationAgentParty()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CalculationAgent.CalculationAgentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CalculationAgent.CalculationAgentBuilder o = (CalculationAgent.CalculationAgentBuilder) other;
			
			merger.mergeRosetta(getCalculationAgentPartyReference(), o.getCalculationAgentPartyReference(), this::getOrCreateCalculationAgentPartyReference);
			
			merger.mergeBasic(getCalculationAgentParty(), o.getCalculationAgentParty(), this::setCalculationAgentParty);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CalculationAgent _that = getType().cast(o);
		
			if (!ListEquals.listEquals(calculationAgentPartyReference, _that.getCalculationAgentPartyReference())) return false;
			if (!Objects.equals(calculationAgentParty, _that.getCalculationAgentParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (calculationAgentPartyReference != null ? calculationAgentPartyReference.hashCode() : 0);
			_result = 31 * _result + (calculationAgentParty != null ? calculationAgentParty.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CalculationAgentBuilder {" +
				"calculationAgentPartyReference=" + this.calculationAgentPartyReference + ", " +
				"calculationAgentParty=" + this.calculationAgentParty +
			'}';
		}
	}
}
