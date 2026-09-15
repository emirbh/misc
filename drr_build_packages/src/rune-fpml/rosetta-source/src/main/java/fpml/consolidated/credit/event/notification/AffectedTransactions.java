package fpml.consolidated.credit.event.notification;

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
import fpml.consolidated.credit.event.notification.meta.AffectedTransactionsMeta;
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
@RosettaDataType(value="AffectedTransactions", builder=AffectedTransactions.AffectedTransactionsBuilderImpl.class, version="2.1.1")
@RuneDataType(value="AffectedTransactions", model="fpml", builder=AffectedTransactions.AffectedTransactionsBuilderImpl.class, version="2.1.1")
public interface AffectedTransactions extends RosettaModelObject {

	AffectedTransactionsMeta metaData = new AffectedTransactionsMeta();

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
	List<? extends AffectedTransactionsChoice> getAffectedTransactionsChoice();

	/*********************** Build Methods  ***********************/
	AffectedTransactions build();
	
	AffectedTransactions.AffectedTransactionsBuilder toBuilder();
	
	static AffectedTransactions.AffectedTransactionsBuilder builder() {
		return new AffectedTransactions.AffectedTransactionsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AffectedTransactions> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AffectedTransactions> getType() {
		return AffectedTransactions.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("affectedTransactionsChoice"), processor, AffectedTransactionsChoice.class, getAffectedTransactionsChoice());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AffectedTransactionsBuilder extends AffectedTransactions, RosettaModelObjectBuilder {
		AffectedTransactionsChoice.AffectedTransactionsChoiceBuilder getOrCreateAffectedTransactionsChoice(int index);
		@Override
		List<? extends AffectedTransactionsChoice.AffectedTransactionsChoiceBuilder> getAffectedTransactionsChoice();
		AffectedTransactions.AffectedTransactionsBuilder addAffectedTransactionsChoice(AffectedTransactionsChoice affectedTransactionsChoice);
		AffectedTransactions.AffectedTransactionsBuilder addAffectedTransactionsChoice(AffectedTransactionsChoice affectedTransactionsChoice, int idx);
		AffectedTransactions.AffectedTransactionsBuilder addAffectedTransactionsChoice(List<? extends AffectedTransactionsChoice> affectedTransactionsChoice);
		AffectedTransactions.AffectedTransactionsBuilder setAffectedTransactionsChoice(List<? extends AffectedTransactionsChoice> affectedTransactionsChoice);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("affectedTransactionsChoice"), processor, AffectedTransactionsChoice.AffectedTransactionsChoiceBuilder.class, getAffectedTransactionsChoice());
		}
		

		AffectedTransactions.AffectedTransactionsBuilder prune();
	}

	/*********************** Immutable Implementation of AffectedTransactions  ***********************/
	class AffectedTransactionsImpl implements AffectedTransactions {
		private final List<? extends AffectedTransactionsChoice> affectedTransactionsChoice;
		
		protected AffectedTransactionsImpl(AffectedTransactions.AffectedTransactionsBuilder builder) {
			this.affectedTransactionsChoice = ofNullable(builder.getAffectedTransactionsChoice()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("affectedTransactionsChoice")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("affectedTransactionsChoice")
		public List<? extends AffectedTransactionsChoice> getAffectedTransactionsChoice() {
			return affectedTransactionsChoice;
		}
		
		@Override
		public AffectedTransactions build() {
			return this;
		}
		
		@Override
		public AffectedTransactions.AffectedTransactionsBuilder toBuilder() {
			AffectedTransactions.AffectedTransactionsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AffectedTransactions.AffectedTransactionsBuilder builder) {
			ofNullable(getAffectedTransactionsChoice()).ifPresent(builder::setAffectedTransactionsChoice);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AffectedTransactions _that = getType().cast(o);
		
			if (!ListEquals.listEquals(affectedTransactionsChoice, _that.getAffectedTransactionsChoice())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (affectedTransactionsChoice != null ? affectedTransactionsChoice.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AffectedTransactions {" +
				"affectedTransactionsChoice=" + this.affectedTransactionsChoice +
			'}';
		}
	}

	/*********************** Builder Implementation of AffectedTransactions  ***********************/
	class AffectedTransactionsBuilderImpl implements AffectedTransactions.AffectedTransactionsBuilder {
	
		protected List<AffectedTransactionsChoice.AffectedTransactionsChoiceBuilder> affectedTransactionsChoice = new ArrayList<>();
		
		@Override
		@RosettaAttribute("affectedTransactionsChoice")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("affectedTransactionsChoice")
		public List<? extends AffectedTransactionsChoice.AffectedTransactionsChoiceBuilder> getAffectedTransactionsChoice() {
			return affectedTransactionsChoice;
		}
		
		@Override
		public AffectedTransactionsChoice.AffectedTransactionsChoiceBuilder getOrCreateAffectedTransactionsChoice(int index) {
			if (affectedTransactionsChoice==null) {
				this.affectedTransactionsChoice = new ArrayList<>();
			}
			return getIndex(affectedTransactionsChoice, index, () -> {
						AffectedTransactionsChoice.AffectedTransactionsChoiceBuilder newAffectedTransactionsChoice = AffectedTransactionsChoice.builder();
						return newAffectedTransactionsChoice;
					});
		}
		
		@RosettaAttribute("affectedTransactionsChoice")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("affectedTransactionsChoice")
		@Override
		public AffectedTransactions.AffectedTransactionsBuilder addAffectedTransactionsChoice(AffectedTransactionsChoice _affectedTransactionsChoice) {
			if (_affectedTransactionsChoice != null) {
				this.affectedTransactionsChoice.add(_affectedTransactionsChoice.toBuilder());
			}
			return this;
		}
		
		@Override
		public AffectedTransactions.AffectedTransactionsBuilder addAffectedTransactionsChoice(AffectedTransactionsChoice _affectedTransactionsChoice, int idx) {
			getIndex(this.affectedTransactionsChoice, idx, () -> _affectedTransactionsChoice.toBuilder());
			return this;
		}
		
		@Override
		public AffectedTransactions.AffectedTransactionsBuilder addAffectedTransactionsChoice(List<? extends AffectedTransactionsChoice> affectedTransactionsChoices) {
			if (affectedTransactionsChoices != null) {
				for (final AffectedTransactionsChoice toAdd : affectedTransactionsChoices) {
					this.affectedTransactionsChoice.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("affectedTransactionsChoice")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("affectedTransactionsChoice")
		@Override
		public AffectedTransactions.AffectedTransactionsBuilder setAffectedTransactionsChoice(List<? extends AffectedTransactionsChoice> affectedTransactionsChoices) {
			if (affectedTransactionsChoices == null) {
				this.affectedTransactionsChoice = new ArrayList<>();
			} else {
				this.affectedTransactionsChoice = affectedTransactionsChoices.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public AffectedTransactions build() {
			return new AffectedTransactions.AffectedTransactionsImpl(this);
		}
		
		@Override
		public AffectedTransactions.AffectedTransactionsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AffectedTransactions.AffectedTransactionsBuilder prune() {
			affectedTransactionsChoice = affectedTransactionsChoice.stream().filter(b->b!=null).<AffectedTransactionsChoice.AffectedTransactionsChoiceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAffectedTransactionsChoice()!=null && getAffectedTransactionsChoice().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AffectedTransactions.AffectedTransactionsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AffectedTransactions.AffectedTransactionsBuilder o = (AffectedTransactions.AffectedTransactionsBuilder) other;
			
			merger.mergeRosetta(getAffectedTransactionsChoice(), o.getAffectedTransactionsChoice(), this::getOrCreateAffectedTransactionsChoice);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AffectedTransactions _that = getType().cast(o);
		
			if (!ListEquals.listEquals(affectedTransactionsChoice, _that.getAffectedTransactionsChoice())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (affectedTransactionsChoice != null ? affectedTransactionsChoice.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AffectedTransactionsBuilder {" +
				"affectedTransactionsChoice=" + this.affectedTransactionsChoice +
			'}';
		}
	}
}
