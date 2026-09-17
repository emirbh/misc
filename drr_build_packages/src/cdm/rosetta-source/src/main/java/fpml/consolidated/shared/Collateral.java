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
import fpml.consolidated.shared.meta.CollateralMeta;
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
 * Provision A type for defining the obligations of the counterparty subject to credit support requirements.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type for defining the obligations of the counterparty subject to credit support requirements.
 *
 */
@RosettaDataType(value="Collateral", builder=Collateral.CollateralBuilderImpl.class, version="2.1.1")
@RuneDataType(value="Collateral", model="fpml", builder=Collateral.CollateralBuilderImpl.class, version="2.1.1")
public interface Collateral extends RosettaModelObject {

	CollateralMeta metaData = new CollateralMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Independent Amount is an amount that usually less creditworthy counterparties are asked to provide. It can either be a fixed amount or a percentage of the Transaction's value. The Independent Amount can be: (i) transferred before any trading between the parties occurs (as a deposit at a third party's account or with the counterparty) or (ii) callable after trading has occurred (typically because a downgrade has occurred). In situation (i), the Independent Amount is not included in the calculation of Exposure, but in situation (ii), it is included in the calculation of Exposure. Thus, for situation (ii), the Independent Amount may be transferred along with any collateral call. Independent Amount is a defined term in the ISDA Credit Support Annex. ("with respect to a party, the amount specified as such for that party in Paragraph 13; if no amount is specified, zero").
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Independent Amount is an amount that usually less creditworthy counterparties are asked to provide. It can either be a fixed amount or a percentage of the Transaction's value. The Independent Amount can be: (i) transferred before any trading between the parties occurs (as a deposit at a third party's account or with the counterparty) or (ii) callable after trading has occurred (typically because a downgrade has occurred). In situation (i), the Independent Amount is not included in the calculation of Exposure, but in situation (ii), it is included in the calculation of Exposure. Thus, for situation (ii), the Independent Amount may be transferred along with any collateral call. Independent Amount is a defined term in the ISDA Credit Support Annex. ("with respect to a party, the amount specified as such for that party in Paragraph 13; if no amount is specified, zero").
	 *
	 */
	List<? extends IndependentAmount> getIndependentAmount();

	/*********************** Build Methods  ***********************/
	Collateral build();
	
	Collateral.CollateralBuilder toBuilder();
	
	static Collateral.CollateralBuilder builder() {
		return new Collateral.CollateralBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Collateral> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Collateral> getType() {
		return Collateral.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("independentAmount"), processor, IndependentAmount.class, getIndependentAmount());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CollateralBuilder extends Collateral, RosettaModelObjectBuilder {
		IndependentAmount.IndependentAmountBuilder getOrCreateIndependentAmount(int index);
		@Override
		List<? extends IndependentAmount.IndependentAmountBuilder> getIndependentAmount();
		Collateral.CollateralBuilder addIndependentAmount(IndependentAmount independentAmount);
		Collateral.CollateralBuilder addIndependentAmount(IndependentAmount independentAmount, int idx);
		Collateral.CollateralBuilder addIndependentAmount(List<? extends IndependentAmount> independentAmount);
		Collateral.CollateralBuilder setIndependentAmount(List<? extends IndependentAmount> independentAmount);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("independentAmount"), processor, IndependentAmount.IndependentAmountBuilder.class, getIndependentAmount());
		}
		

		Collateral.CollateralBuilder prune();
	}

	/*********************** Immutable Implementation of Collateral  ***********************/
	class CollateralImpl implements Collateral {
		private final List<? extends IndependentAmount> independentAmount;
		
		protected CollateralImpl(Collateral.CollateralBuilder builder) {
			this.independentAmount = ofNullable(builder.getIndependentAmount()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("independentAmount")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("independentAmount")
		public List<? extends IndependentAmount> getIndependentAmount() {
			return independentAmount;
		}
		
		@Override
		public Collateral build() {
			return this;
		}
		
		@Override
		public Collateral.CollateralBuilder toBuilder() {
			Collateral.CollateralBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Collateral.CollateralBuilder builder) {
			ofNullable(getIndependentAmount()).ifPresent(builder::setIndependentAmount);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Collateral _that = getType().cast(o);
		
			if (!ListEquals.listEquals(independentAmount, _that.getIndependentAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (independentAmount != null ? independentAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Collateral {" +
				"independentAmount=" + this.independentAmount +
			'}';
		}
	}

	/*********************** Builder Implementation of Collateral  ***********************/
	class CollateralBuilderImpl implements Collateral.CollateralBuilder {
	
		protected List<IndependentAmount.IndependentAmountBuilder> independentAmount = new ArrayList<>();
		
		@Override
		@RosettaAttribute("independentAmount")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("independentAmount")
		public List<? extends IndependentAmount.IndependentAmountBuilder> getIndependentAmount() {
			return independentAmount;
		}
		
		@Override
		public IndependentAmount.IndependentAmountBuilder getOrCreateIndependentAmount(int index) {
			if (independentAmount==null) {
				this.independentAmount = new ArrayList<>();
			}
			return getIndex(independentAmount, index, () -> {
						IndependentAmount.IndependentAmountBuilder newIndependentAmount = IndependentAmount.builder();
						return newIndependentAmount;
					});
		}
		
		@RosettaAttribute("independentAmount")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("independentAmount")
		@Override
		public Collateral.CollateralBuilder addIndependentAmount(IndependentAmount _independentAmount) {
			if (_independentAmount != null) {
				this.independentAmount.add(_independentAmount.toBuilder());
			}
			return this;
		}
		
		@Override
		public Collateral.CollateralBuilder addIndependentAmount(IndependentAmount _independentAmount, int idx) {
			getIndex(this.independentAmount, idx, () -> _independentAmount.toBuilder());
			return this;
		}
		
		@Override
		public Collateral.CollateralBuilder addIndependentAmount(List<? extends IndependentAmount> independentAmounts) {
			if (independentAmounts != null) {
				for (final IndependentAmount toAdd : independentAmounts) {
					this.independentAmount.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("independentAmount")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("independentAmount")
		@Override
		public Collateral.CollateralBuilder setIndependentAmount(List<? extends IndependentAmount> independentAmounts) {
			if (independentAmounts == null) {
				this.independentAmount = new ArrayList<>();
			} else {
				this.independentAmount = independentAmounts.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public Collateral build() {
			return new Collateral.CollateralImpl(this);
		}
		
		@Override
		public Collateral.CollateralBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Collateral.CollateralBuilder prune() {
			independentAmount = independentAmount.stream().filter(b->b!=null).<IndependentAmount.IndependentAmountBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getIndependentAmount()!=null && getIndependentAmount().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Collateral.CollateralBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Collateral.CollateralBuilder o = (Collateral.CollateralBuilder) other;
			
			merger.mergeRosetta(getIndependentAmount(), o.getIndependentAmount(), this::getOrCreateIndependentAmount);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Collateral _that = getType().cast(o);
		
			if (!ListEquals.listEquals(independentAmount, _that.getIndependentAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (independentAmount != null ? independentAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CollateralBuilder {" +
				"independentAmount=" + this.independentAmount +
			'}';
		}
	}
}
