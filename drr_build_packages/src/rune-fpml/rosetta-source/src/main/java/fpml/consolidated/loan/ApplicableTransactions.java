package fpml.consolidated.loan;

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
import fpml.consolidated.fpmlenum.LoanAllTransactionsEnum;
import fpml.consolidated.loan.meta.ApplicableTransactionsMeta;
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
 * Provision A structure that defines specific servicing transactions that a particular payment profile may be associated with.
 *
 */
@RosettaDataType(value="ApplicableTransactions", builder=ApplicableTransactions.ApplicableTransactionsBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ApplicableTransactions", model="fpml", builder=ApplicableTransactions.ApplicableTransactionsBuilderImpl.class, version="2.1.1")
public interface ApplicableTransactions extends RosettaModelObject {

	ApplicableTransactionsMeta metaData = new ApplicableTransactionsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A scheme that describes transaction types.
	 *
	 */
	List<? extends ApplicableTransactionType> getApplicableTransactionType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A list with a single 'all' value to explicitly indicate all transactions are applicable.
	 *
	 */
	LoanAllTransactionsEnum getAllTransactions();

	/*********************** Build Methods  ***********************/
	ApplicableTransactions build();
	
	ApplicableTransactions.ApplicableTransactionsBuilder toBuilder();
	
	static ApplicableTransactions.ApplicableTransactionsBuilder builder() {
		return new ApplicableTransactions.ApplicableTransactionsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ApplicableTransactions> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ApplicableTransactions> getType() {
		return ApplicableTransactions.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("applicableTransactionType"), processor, ApplicableTransactionType.class, getApplicableTransactionType());
		processor.processBasic(path.newSubPath("allTransactions"), LoanAllTransactionsEnum.class, getAllTransactions(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ApplicableTransactionsBuilder extends ApplicableTransactions, RosettaModelObjectBuilder {
		ApplicableTransactionType.ApplicableTransactionTypeBuilder getOrCreateApplicableTransactionType(int index);
		@Override
		List<? extends ApplicableTransactionType.ApplicableTransactionTypeBuilder> getApplicableTransactionType();
		ApplicableTransactions.ApplicableTransactionsBuilder addApplicableTransactionType(ApplicableTransactionType applicableTransactionType);
		ApplicableTransactions.ApplicableTransactionsBuilder addApplicableTransactionType(ApplicableTransactionType applicableTransactionType, int idx);
		ApplicableTransactions.ApplicableTransactionsBuilder addApplicableTransactionType(List<? extends ApplicableTransactionType> applicableTransactionType);
		ApplicableTransactions.ApplicableTransactionsBuilder setApplicableTransactionType(List<? extends ApplicableTransactionType> applicableTransactionType);
		ApplicableTransactions.ApplicableTransactionsBuilder setAllTransactions(LoanAllTransactionsEnum allTransactions);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("applicableTransactionType"), processor, ApplicableTransactionType.ApplicableTransactionTypeBuilder.class, getApplicableTransactionType());
			processor.processBasic(path.newSubPath("allTransactions"), LoanAllTransactionsEnum.class, getAllTransactions(), this);
		}
		

		ApplicableTransactions.ApplicableTransactionsBuilder prune();
	}

	/*********************** Immutable Implementation of ApplicableTransactions  ***********************/
	class ApplicableTransactionsImpl implements ApplicableTransactions {
		private final List<? extends ApplicableTransactionType> applicableTransactionType;
		private final LoanAllTransactionsEnum allTransactions;
		
		protected ApplicableTransactionsImpl(ApplicableTransactions.ApplicableTransactionsBuilder builder) {
			this.applicableTransactionType = ofNullable(builder.getApplicableTransactionType()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.allTransactions = builder.getAllTransactions();
		}
		
		@Override
		@RosettaAttribute("applicableTransactionType")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("applicableTransactionType")
		public List<? extends ApplicableTransactionType> getApplicableTransactionType() {
			return applicableTransactionType;
		}
		
		@Override
		@RosettaAttribute("allTransactions")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("allTransactions")
		public LoanAllTransactionsEnum getAllTransactions() {
			return allTransactions;
		}
		
		@Override
		public ApplicableTransactions build() {
			return this;
		}
		
		@Override
		public ApplicableTransactions.ApplicableTransactionsBuilder toBuilder() {
			ApplicableTransactions.ApplicableTransactionsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ApplicableTransactions.ApplicableTransactionsBuilder builder) {
			ofNullable(getApplicableTransactionType()).ifPresent(builder::setApplicableTransactionType);
			ofNullable(getAllTransactions()).ifPresent(builder::setAllTransactions);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ApplicableTransactions _that = getType().cast(o);
		
			if (!ListEquals.listEquals(applicableTransactionType, _that.getApplicableTransactionType())) return false;
			if (!Objects.equals(allTransactions, _that.getAllTransactions())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (applicableTransactionType != null ? applicableTransactionType.hashCode() : 0);
			_result = 31 * _result + (allTransactions != null ? allTransactions.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ApplicableTransactions {" +
				"applicableTransactionType=" + this.applicableTransactionType + ", " +
				"allTransactions=" + this.allTransactions +
			'}';
		}
	}

	/*********************** Builder Implementation of ApplicableTransactions  ***********************/
	class ApplicableTransactionsBuilderImpl implements ApplicableTransactions.ApplicableTransactionsBuilder {
	
		protected List<ApplicableTransactionType.ApplicableTransactionTypeBuilder> applicableTransactionType = new ArrayList<>();
		protected LoanAllTransactionsEnum allTransactions;
		
		@Override
		@RosettaAttribute("applicableTransactionType")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("applicableTransactionType")
		public List<? extends ApplicableTransactionType.ApplicableTransactionTypeBuilder> getApplicableTransactionType() {
			return applicableTransactionType;
		}
		
		@Override
		public ApplicableTransactionType.ApplicableTransactionTypeBuilder getOrCreateApplicableTransactionType(int index) {
			if (applicableTransactionType==null) {
				this.applicableTransactionType = new ArrayList<>();
			}
			return getIndex(applicableTransactionType, index, () -> {
						ApplicableTransactionType.ApplicableTransactionTypeBuilder newApplicableTransactionType = ApplicableTransactionType.builder();
						return newApplicableTransactionType;
					});
		}
		
		@Override
		@RosettaAttribute("allTransactions")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("allTransactions")
		public LoanAllTransactionsEnum getAllTransactions() {
			return allTransactions;
		}
		
		@RosettaAttribute("applicableTransactionType")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("applicableTransactionType")
		@Override
		public ApplicableTransactions.ApplicableTransactionsBuilder addApplicableTransactionType(ApplicableTransactionType _applicableTransactionType) {
			if (_applicableTransactionType != null) {
				this.applicableTransactionType.add(_applicableTransactionType.toBuilder());
			}
			return this;
		}
		
		@Override
		public ApplicableTransactions.ApplicableTransactionsBuilder addApplicableTransactionType(ApplicableTransactionType _applicableTransactionType, int idx) {
			getIndex(this.applicableTransactionType, idx, () -> _applicableTransactionType.toBuilder());
			return this;
		}
		
		@Override
		public ApplicableTransactions.ApplicableTransactionsBuilder addApplicableTransactionType(List<? extends ApplicableTransactionType> applicableTransactionTypes) {
			if (applicableTransactionTypes != null) {
				for (final ApplicableTransactionType toAdd : applicableTransactionTypes) {
					this.applicableTransactionType.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("applicableTransactionType")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("applicableTransactionType")
		@Override
		public ApplicableTransactions.ApplicableTransactionsBuilder setApplicableTransactionType(List<? extends ApplicableTransactionType> applicableTransactionTypes) {
			if (applicableTransactionTypes == null) {
				this.applicableTransactionType = new ArrayList<>();
			} else {
				this.applicableTransactionType = applicableTransactionTypes.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("allTransactions")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("allTransactions")
		@Override
		public ApplicableTransactions.ApplicableTransactionsBuilder setAllTransactions(LoanAllTransactionsEnum _allTransactions) {
			this.allTransactions = _allTransactions == null ? null : _allTransactions;
			return this;
		}
		
		@Override
		public ApplicableTransactions build() {
			return new ApplicableTransactions.ApplicableTransactionsImpl(this);
		}
		
		@Override
		public ApplicableTransactions.ApplicableTransactionsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ApplicableTransactions.ApplicableTransactionsBuilder prune() {
			applicableTransactionType = applicableTransactionType.stream().filter(b->b!=null).<ApplicableTransactionType.ApplicableTransactionTypeBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getApplicableTransactionType()!=null && getApplicableTransactionType().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getAllTransactions()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ApplicableTransactions.ApplicableTransactionsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ApplicableTransactions.ApplicableTransactionsBuilder o = (ApplicableTransactions.ApplicableTransactionsBuilder) other;
			
			merger.mergeRosetta(getApplicableTransactionType(), o.getApplicableTransactionType(), this::getOrCreateApplicableTransactionType);
			
			merger.mergeBasic(getAllTransactions(), o.getAllTransactions(), this::setAllTransactions);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ApplicableTransactions _that = getType().cast(o);
		
			if (!ListEquals.listEquals(applicableTransactionType, _that.getApplicableTransactionType())) return false;
			if (!Objects.equals(allTransactions, _that.getAllTransactions())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (applicableTransactionType != null ? applicableTransactionType.hashCode() : 0);
			_result = 31 * _result + (allTransactions != null ? allTransactions.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ApplicableTransactionsBuilder {" +
				"applicableTransactionType=" + this.applicableTransactionType + ", " +
				"allTransactions=" + this.allTransactions +
			'}';
		}
	}
}
