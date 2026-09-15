package fpml.consolidated.riskdef;

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
import fpml.consolidated.riskdef.meta.PricingDataPointCoordinateMeta;
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
 * Provision A set of index values that identify a pricing data point. For example: (strike = 17%, expiration = 6M, term = 1Y.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A set of index values that identify a pricing data point. For example: (strike = 17%, expiration = 6M, term = 1Y.
 *
 */
@RosettaDataType(value="PricingDataPointCoordinate", builder=PricingDataPointCoordinate.PricingDataPointCoordinateBuilderImpl.class, version="2.1.1")
@RuneDataType(value="PricingDataPointCoordinate", model="fpml", builder=PricingDataPointCoordinate.PricingDataPointCoordinateBuilderImpl.class, version="2.1.1")
public interface PricingDataPointCoordinate extends RosettaModelObject {

	PricingDataPointCoordinateMeta metaData = new PricingDataPointCoordinateMeta();

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
	String getId();
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
	List<? extends PricingDataPointCoordinateChoice> getPricingDataPointCoordinateChoice();

	/*********************** Build Methods  ***********************/
	PricingDataPointCoordinate build();
	
	PricingDataPointCoordinate.PricingDataPointCoordinateBuilder toBuilder();
	
	static PricingDataPointCoordinate.PricingDataPointCoordinateBuilder builder() {
		return new PricingDataPointCoordinate.PricingDataPointCoordinateBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PricingDataPointCoordinate> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends PricingDataPointCoordinate> getType() {
		return PricingDataPointCoordinate.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("pricingDataPointCoordinateChoice"), processor, PricingDataPointCoordinateChoice.class, getPricingDataPointCoordinateChoice());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PricingDataPointCoordinateBuilder extends PricingDataPointCoordinate, RosettaModelObjectBuilder {
		PricingDataPointCoordinateChoice.PricingDataPointCoordinateChoiceBuilder getOrCreatePricingDataPointCoordinateChoice(int index);
		@Override
		List<? extends PricingDataPointCoordinateChoice.PricingDataPointCoordinateChoiceBuilder> getPricingDataPointCoordinateChoice();
		PricingDataPointCoordinate.PricingDataPointCoordinateBuilder setId(String id);
		PricingDataPointCoordinate.PricingDataPointCoordinateBuilder addPricingDataPointCoordinateChoice(PricingDataPointCoordinateChoice pricingDataPointCoordinateChoice);
		PricingDataPointCoordinate.PricingDataPointCoordinateBuilder addPricingDataPointCoordinateChoice(PricingDataPointCoordinateChoice pricingDataPointCoordinateChoice, int idx);
		PricingDataPointCoordinate.PricingDataPointCoordinateBuilder addPricingDataPointCoordinateChoice(List<? extends PricingDataPointCoordinateChoice> pricingDataPointCoordinateChoice);
		PricingDataPointCoordinate.PricingDataPointCoordinateBuilder setPricingDataPointCoordinateChoice(List<? extends PricingDataPointCoordinateChoice> pricingDataPointCoordinateChoice);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("pricingDataPointCoordinateChoice"), processor, PricingDataPointCoordinateChoice.PricingDataPointCoordinateChoiceBuilder.class, getPricingDataPointCoordinateChoice());
		}
		

		PricingDataPointCoordinate.PricingDataPointCoordinateBuilder prune();
	}

	/*********************** Immutable Implementation of PricingDataPointCoordinate  ***********************/
	class PricingDataPointCoordinateImpl implements PricingDataPointCoordinate {
		private final String id;
		private final List<? extends PricingDataPointCoordinateChoice> pricingDataPointCoordinateChoice;
		
		protected PricingDataPointCoordinateImpl(PricingDataPointCoordinate.PricingDataPointCoordinateBuilder builder) {
			this.id = builder.getId();
			this.pricingDataPointCoordinateChoice = ofNullable(builder.getPricingDataPointCoordinateChoice()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("pricingDataPointCoordinateChoice")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("pricingDataPointCoordinateChoice")
		public List<? extends PricingDataPointCoordinateChoice> getPricingDataPointCoordinateChoice() {
			return pricingDataPointCoordinateChoice;
		}
		
		@Override
		public PricingDataPointCoordinate build() {
			return this;
		}
		
		@Override
		public PricingDataPointCoordinate.PricingDataPointCoordinateBuilder toBuilder() {
			PricingDataPointCoordinate.PricingDataPointCoordinateBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PricingDataPointCoordinate.PricingDataPointCoordinateBuilder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getPricingDataPointCoordinateChoice()).ifPresent(builder::setPricingDataPointCoordinateChoice);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PricingDataPointCoordinate _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!ListEquals.listEquals(pricingDataPointCoordinateChoice, _that.getPricingDataPointCoordinateChoice())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (pricingDataPointCoordinateChoice != null ? pricingDataPointCoordinateChoice.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PricingDataPointCoordinate {" +
				"id=" + this.id + ", " +
				"pricingDataPointCoordinateChoice=" + this.pricingDataPointCoordinateChoice +
			'}';
		}
	}

	/*********************** Builder Implementation of PricingDataPointCoordinate  ***********************/
	class PricingDataPointCoordinateBuilderImpl implements PricingDataPointCoordinate.PricingDataPointCoordinateBuilder {
	
		protected String id;
		protected List<PricingDataPointCoordinateChoice.PricingDataPointCoordinateChoiceBuilder> pricingDataPointCoordinateChoice = new ArrayList<>();
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("pricingDataPointCoordinateChoice")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("pricingDataPointCoordinateChoice")
		public List<? extends PricingDataPointCoordinateChoice.PricingDataPointCoordinateChoiceBuilder> getPricingDataPointCoordinateChoice() {
			return pricingDataPointCoordinateChoice;
		}
		
		@Override
		public PricingDataPointCoordinateChoice.PricingDataPointCoordinateChoiceBuilder getOrCreatePricingDataPointCoordinateChoice(int index) {
			if (pricingDataPointCoordinateChoice==null) {
				this.pricingDataPointCoordinateChoice = new ArrayList<>();
			}
			return getIndex(pricingDataPointCoordinateChoice, index, () -> {
						PricingDataPointCoordinateChoice.PricingDataPointCoordinateChoiceBuilder newPricingDataPointCoordinateChoice = PricingDataPointCoordinateChoice.builder();
						return newPricingDataPointCoordinateChoice;
					});
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public PricingDataPointCoordinate.PricingDataPointCoordinateBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("pricingDataPointCoordinateChoice")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("pricingDataPointCoordinateChoice")
		@Override
		public PricingDataPointCoordinate.PricingDataPointCoordinateBuilder addPricingDataPointCoordinateChoice(PricingDataPointCoordinateChoice _pricingDataPointCoordinateChoice) {
			if (_pricingDataPointCoordinateChoice != null) {
				this.pricingDataPointCoordinateChoice.add(_pricingDataPointCoordinateChoice.toBuilder());
			}
			return this;
		}
		
		@Override
		public PricingDataPointCoordinate.PricingDataPointCoordinateBuilder addPricingDataPointCoordinateChoice(PricingDataPointCoordinateChoice _pricingDataPointCoordinateChoice, int idx) {
			getIndex(this.pricingDataPointCoordinateChoice, idx, () -> _pricingDataPointCoordinateChoice.toBuilder());
			return this;
		}
		
		@Override
		public PricingDataPointCoordinate.PricingDataPointCoordinateBuilder addPricingDataPointCoordinateChoice(List<? extends PricingDataPointCoordinateChoice> pricingDataPointCoordinateChoices) {
			if (pricingDataPointCoordinateChoices != null) {
				for (final PricingDataPointCoordinateChoice toAdd : pricingDataPointCoordinateChoices) {
					this.pricingDataPointCoordinateChoice.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("pricingDataPointCoordinateChoice")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("pricingDataPointCoordinateChoice")
		@Override
		public PricingDataPointCoordinate.PricingDataPointCoordinateBuilder setPricingDataPointCoordinateChoice(List<? extends PricingDataPointCoordinateChoice> pricingDataPointCoordinateChoices) {
			if (pricingDataPointCoordinateChoices == null) {
				this.pricingDataPointCoordinateChoice = new ArrayList<>();
			} else {
				this.pricingDataPointCoordinateChoice = pricingDataPointCoordinateChoices.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public PricingDataPointCoordinate build() {
			return new PricingDataPointCoordinate.PricingDataPointCoordinateImpl(this);
		}
		
		@Override
		public PricingDataPointCoordinate.PricingDataPointCoordinateBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PricingDataPointCoordinate.PricingDataPointCoordinateBuilder prune() {
			pricingDataPointCoordinateChoice = pricingDataPointCoordinateChoice.stream().filter(b->b!=null).<PricingDataPointCoordinateChoice.PricingDataPointCoordinateChoiceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			if (getPricingDataPointCoordinateChoice()!=null && getPricingDataPointCoordinateChoice().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PricingDataPointCoordinate.PricingDataPointCoordinateBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PricingDataPointCoordinate.PricingDataPointCoordinateBuilder o = (PricingDataPointCoordinate.PricingDataPointCoordinateBuilder) other;
			
			merger.mergeRosetta(getPricingDataPointCoordinateChoice(), o.getPricingDataPointCoordinateChoice(), this::getOrCreatePricingDataPointCoordinateChoice);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PricingDataPointCoordinate _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!ListEquals.listEquals(pricingDataPointCoordinateChoice, _that.getPricingDataPointCoordinateChoice())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (pricingDataPointCoordinateChoice != null ? pricingDataPointCoordinateChoice.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PricingDataPointCoordinateBuilder {" +
				"id=" + this.id + ", " +
				"pricingDataPointCoordinateChoice=" + this.pricingDataPointCoordinateChoice +
			'}';
		}
	}
}
