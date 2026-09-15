package fpml.consolidated.loan;

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
import fpml.consolidated.loan.meta.LoanContractListMeta;
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
 * version "confirmation-5.13"
 *
 * Provision A list of loan contracts.
 *
 */
@RosettaDataType(value="LoanContractList", builder=LoanContractList.LoanContractListBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LoanContractList", model="fpml", builder=LoanContractList.LoanContractListBuilderImpl.class, version="2.1.1")
public interface LoanContractList extends RosettaModelObject {

	LoanContractListMeta metaData = new LoanContractListMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	List<? extends LoanContract> getContract();

	/*********************** Build Methods  ***********************/
	LoanContractList build();
	
	LoanContractList.LoanContractListBuilder toBuilder();
	
	static LoanContractList.LoanContractListBuilder builder() {
		return new LoanContractList.LoanContractListBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanContractList> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LoanContractList> getType() {
		return LoanContractList.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("contract"), processor, LoanContract.class, getContract());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanContractListBuilder extends LoanContractList, RosettaModelObjectBuilder {
		LoanContract.LoanContractBuilder getOrCreateContract(int index);
		@Override
		List<? extends LoanContract.LoanContractBuilder> getContract();
		LoanContractList.LoanContractListBuilder addContract(LoanContract contract);
		LoanContractList.LoanContractListBuilder addContract(LoanContract contract, int idx);
		LoanContractList.LoanContractListBuilder addContract(List<? extends LoanContract> contract);
		LoanContractList.LoanContractListBuilder setContract(List<? extends LoanContract> contract);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("contract"), processor, LoanContract.LoanContractBuilder.class, getContract());
		}
		

		LoanContractList.LoanContractListBuilder prune();
	}

	/*********************** Immutable Implementation of LoanContractList  ***********************/
	class LoanContractListImpl implements LoanContractList {
		private final List<? extends LoanContract> contract;
		
		protected LoanContractListImpl(LoanContractList.LoanContractListBuilder builder) {
			this.contract = ofNullable(builder.getContract()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("contract")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("contract")
		public List<? extends LoanContract> getContract() {
			return contract;
		}
		
		@Override
		public LoanContractList build() {
			return this;
		}
		
		@Override
		public LoanContractList.LoanContractListBuilder toBuilder() {
			LoanContractList.LoanContractListBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanContractList.LoanContractListBuilder builder) {
			ofNullable(getContract()).ifPresent(builder::setContract);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanContractList _that = getType().cast(o);
		
			if (!ListEquals.listEquals(contract, _that.getContract())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (contract != null ? contract.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanContractList {" +
				"contract=" + this.contract +
			'}';
		}
	}

	/*********************** Builder Implementation of LoanContractList  ***********************/
	class LoanContractListBuilderImpl implements LoanContractList.LoanContractListBuilder {
	
		protected List<LoanContract.LoanContractBuilder> contract = new ArrayList<>();
		
		@Override
		@RosettaAttribute("contract")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("contract")
		public List<? extends LoanContract.LoanContractBuilder> getContract() {
			return contract;
		}
		
		@Override
		public LoanContract.LoanContractBuilder getOrCreateContract(int index) {
			if (contract==null) {
				this.contract = new ArrayList<>();
			}
			return getIndex(contract, index, () -> {
						LoanContract.LoanContractBuilder newContract = LoanContract.builder();
						return newContract;
					});
		}
		
		@RosettaAttribute("contract")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("contract")
		@Override
		public LoanContractList.LoanContractListBuilder addContract(LoanContract _contract) {
			if (_contract != null) {
				this.contract.add(_contract.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanContractList.LoanContractListBuilder addContract(LoanContract _contract, int idx) {
			getIndex(this.contract, idx, () -> _contract.toBuilder());
			return this;
		}
		
		@Override
		public LoanContractList.LoanContractListBuilder addContract(List<? extends LoanContract> contracts) {
			if (contracts != null) {
				for (final LoanContract toAdd : contracts) {
					this.contract.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("contract")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("contract")
		@Override
		public LoanContractList.LoanContractListBuilder setContract(List<? extends LoanContract> contracts) {
			if (contracts == null) {
				this.contract = new ArrayList<>();
			} else {
				this.contract = contracts.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public LoanContractList build() {
			return new LoanContractList.LoanContractListImpl(this);
		}
		
		@Override
		public LoanContractList.LoanContractListBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanContractList.LoanContractListBuilder prune() {
			contract = contract.stream().filter(b->b!=null).<LoanContract.LoanContractBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getContract()!=null && getContract().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanContractList.LoanContractListBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LoanContractList.LoanContractListBuilder o = (LoanContractList.LoanContractListBuilder) other;
			
			merger.mergeRosetta(getContract(), o.getContract(), this::getOrCreateContract);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanContractList _that = getType().cast(o);
		
			if (!ListEquals.listEquals(contract, _that.getContract())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (contract != null ? contract.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanContractListBuilder {" +
				"contract=" + this.contract +
			'}';
		}
	}
}
