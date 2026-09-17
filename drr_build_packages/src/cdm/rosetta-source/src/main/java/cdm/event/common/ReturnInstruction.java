package cdm.event.common;

import cdm.base.math.Quantity;
import cdm.event.common.meta.ReturnInstructionMeta;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Specifies the information required to create the return of a Security Finance Transaction.
 * @version 6.23.0
 */
@RosettaDataType(value="ReturnInstruction", builder=ReturnInstruction.ReturnInstructionBuilderImpl.class, version="6.23.0")
@RuneDataType(value="ReturnInstruction", model="cdm", builder=ReturnInstruction.ReturnInstructionBuilderImpl.class, version="6.23.0")
public interface ReturnInstruction extends RosettaModelObject {

	ReturnInstructionMeta metaData = new ReturnInstructionMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies the quantity of shares and cash to be returned in a partial return event.
	 */
	List<? extends Quantity> getQuantity();

	/*********************** Build Methods  ***********************/
	ReturnInstruction build();
	
	ReturnInstruction.ReturnInstructionBuilder toBuilder();
	
	static ReturnInstruction.ReturnInstructionBuilder builder() {
		return new ReturnInstruction.ReturnInstructionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ReturnInstruction> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ReturnInstruction> getType() {
		return ReturnInstruction.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("quantity"), processor, Quantity.class, getQuantity());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ReturnInstructionBuilder extends ReturnInstruction, RosettaModelObjectBuilder {
		Quantity.QuantityBuilder getOrCreateQuantity(int index);
		@Override
		List<? extends Quantity.QuantityBuilder> getQuantity();
		ReturnInstruction.ReturnInstructionBuilder addQuantity(Quantity quantity);
		ReturnInstruction.ReturnInstructionBuilder addQuantity(Quantity quantity, int idx);
		ReturnInstruction.ReturnInstructionBuilder addQuantity(List<? extends Quantity> quantity);
		ReturnInstruction.ReturnInstructionBuilder setQuantity(List<? extends Quantity> quantity);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("quantity"), processor, Quantity.QuantityBuilder.class, getQuantity());
		}
		

		ReturnInstruction.ReturnInstructionBuilder prune();
	}

	/*********************** Immutable Implementation of ReturnInstruction  ***********************/
	class ReturnInstructionImpl implements ReturnInstruction {
		private final List<? extends Quantity> quantity;
		
		protected ReturnInstructionImpl(ReturnInstruction.ReturnInstructionBuilder builder) {
			this.quantity = ofNullable(builder.getQuantity()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("quantity")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("quantity")
		public List<? extends Quantity> getQuantity() {
			return quantity;
		}
		
		@Override
		public ReturnInstruction build() {
			return this;
		}
		
		@Override
		public ReturnInstruction.ReturnInstructionBuilder toBuilder() {
			ReturnInstruction.ReturnInstructionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ReturnInstruction.ReturnInstructionBuilder builder) {
			ofNullable(getQuantity()).ifPresent(builder::setQuantity);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReturnInstruction _that = getType().cast(o);
		
			if (!ListEquals.listEquals(quantity, _that.getQuantity())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (quantity != null ? quantity.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReturnInstruction {" +
				"quantity=" + this.quantity +
			'}';
		}
	}

	/*********************** Builder Implementation of ReturnInstruction  ***********************/
	class ReturnInstructionBuilderImpl implements ReturnInstruction.ReturnInstructionBuilder {
	
		protected List<Quantity.QuantityBuilder> quantity = new ArrayList<>();
		
		@Override
		@RosettaAttribute("quantity")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("quantity")
		public List<? extends Quantity.QuantityBuilder> getQuantity() {
			return quantity;
		}
		
		@Override
		public Quantity.QuantityBuilder getOrCreateQuantity(int index) {
			if (quantity==null) {
				this.quantity = new ArrayList<>();
			}
			return getIndex(quantity, index, () -> {
						Quantity.QuantityBuilder newQuantity = Quantity.builder();
						return newQuantity;
					});
		}
		
		@RosettaAttribute("quantity")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("quantity")
		@Override
		public ReturnInstruction.ReturnInstructionBuilder addQuantity(Quantity _quantity) {
			if (_quantity != null) {
				this.quantity.add(_quantity.toBuilder());
			}
			return this;
		}
		
		@Override
		public ReturnInstruction.ReturnInstructionBuilder addQuantity(Quantity _quantity, int idx) {
			getIndex(this.quantity, idx, () -> _quantity.toBuilder());
			return this;
		}
		
		@Override
		public ReturnInstruction.ReturnInstructionBuilder addQuantity(List<? extends Quantity> quantitys) {
			if (quantitys != null) {
				for (final Quantity toAdd : quantitys) {
					this.quantity.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("quantity")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("quantity")
		@Override
		public ReturnInstruction.ReturnInstructionBuilder setQuantity(List<? extends Quantity> quantitys) {
			if (quantitys == null) {
				this.quantity = new ArrayList<>();
			} else {
				this.quantity = quantitys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public ReturnInstruction build() {
			return new ReturnInstruction.ReturnInstructionImpl(this);
		}
		
		@Override
		public ReturnInstruction.ReturnInstructionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReturnInstruction.ReturnInstructionBuilder prune() {
			quantity = quantity.stream().filter(b->b!=null).<Quantity.QuantityBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getQuantity()!=null && getQuantity().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReturnInstruction.ReturnInstructionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ReturnInstruction.ReturnInstructionBuilder o = (ReturnInstruction.ReturnInstructionBuilder) other;
			
			merger.mergeRosetta(getQuantity(), o.getQuantity(), this::getOrCreateQuantity);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReturnInstruction _that = getType().cast(o);
		
			if (!ListEquals.listEquals(quantity, _that.getQuantity())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (quantity != null ? quantity.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReturnInstructionBuilder {" +
				"quantity=" + this.quantity +
			'}';
		}
	}
}
