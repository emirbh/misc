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
import fpml.consolidated.loan.meta.LoanContractsReferenceMeta;
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
 * Provision A list of references to loan contracts.
 *
 */
@RosettaDataType(value="LoanContractsReference", builder=LoanContractsReference.LoanContractsReferenceBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LoanContractsReference", model="fpml", builder=LoanContractsReference.LoanContractsReferenceBuilderImpl.class, version="2.1.1")
public interface LoanContractsReference extends RosettaModelObject {

	LoanContractsReferenceMeta metaData = new LoanContractsReferenceMeta();

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
	List<? extends LoanContractReference> getLoanContractReference();

	/*********************** Build Methods  ***********************/
	LoanContractsReference build();
	
	LoanContractsReference.LoanContractsReferenceBuilder toBuilder();
	
	static LoanContractsReference.LoanContractsReferenceBuilder builder() {
		return new LoanContractsReference.LoanContractsReferenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanContractsReference> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LoanContractsReference> getType() {
		return LoanContractsReference.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("loanContractReference"), processor, LoanContractReference.class, getLoanContractReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanContractsReferenceBuilder extends LoanContractsReference, RosettaModelObjectBuilder {
		LoanContractReference.LoanContractReferenceBuilder getOrCreateLoanContractReference(int index);
		@Override
		List<? extends LoanContractReference.LoanContractReferenceBuilder> getLoanContractReference();
		LoanContractsReference.LoanContractsReferenceBuilder addLoanContractReference(LoanContractReference loanContractReference);
		LoanContractsReference.LoanContractsReferenceBuilder addLoanContractReference(LoanContractReference loanContractReference, int idx);
		LoanContractsReference.LoanContractsReferenceBuilder addLoanContractReference(List<? extends LoanContractReference> loanContractReference);
		LoanContractsReference.LoanContractsReferenceBuilder setLoanContractReference(List<? extends LoanContractReference> loanContractReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("loanContractReference"), processor, LoanContractReference.LoanContractReferenceBuilder.class, getLoanContractReference());
		}
		

		LoanContractsReference.LoanContractsReferenceBuilder prune();
	}

	/*********************** Immutable Implementation of LoanContractsReference  ***********************/
	class LoanContractsReferenceImpl implements LoanContractsReference {
		private final List<? extends LoanContractReference> loanContractReference;
		
		protected LoanContractsReferenceImpl(LoanContractsReference.LoanContractsReferenceBuilder builder) {
			this.loanContractReference = ofNullable(builder.getLoanContractReference()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("loanContractReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("loanContractReference")
		public List<? extends LoanContractReference> getLoanContractReference() {
			return loanContractReference;
		}
		
		@Override
		public LoanContractsReference build() {
			return this;
		}
		
		@Override
		public LoanContractsReference.LoanContractsReferenceBuilder toBuilder() {
			LoanContractsReference.LoanContractsReferenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanContractsReference.LoanContractsReferenceBuilder builder) {
			ofNullable(getLoanContractReference()).ifPresent(builder::setLoanContractReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanContractsReference _that = getType().cast(o);
		
			if (!ListEquals.listEquals(loanContractReference, _that.getLoanContractReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (loanContractReference != null ? loanContractReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanContractsReference {" +
				"loanContractReference=" + this.loanContractReference +
			'}';
		}
	}

	/*********************** Builder Implementation of LoanContractsReference  ***********************/
	class LoanContractsReferenceBuilderImpl implements LoanContractsReference.LoanContractsReferenceBuilder {
	
		protected List<LoanContractReference.LoanContractReferenceBuilder> loanContractReference = new ArrayList<>();
		
		@Override
		@RosettaAttribute("loanContractReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("loanContractReference")
		public List<? extends LoanContractReference.LoanContractReferenceBuilder> getLoanContractReference() {
			return loanContractReference;
		}
		
		@Override
		public LoanContractReference.LoanContractReferenceBuilder getOrCreateLoanContractReference(int index) {
			if (loanContractReference==null) {
				this.loanContractReference = new ArrayList<>();
			}
			return getIndex(loanContractReference, index, () -> {
						LoanContractReference.LoanContractReferenceBuilder newLoanContractReference = LoanContractReference.builder();
						return newLoanContractReference;
					});
		}
		
		@RosettaAttribute("loanContractReference")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("loanContractReference")
		@Override
		public LoanContractsReference.LoanContractsReferenceBuilder addLoanContractReference(LoanContractReference _loanContractReference) {
			if (_loanContractReference != null) {
				this.loanContractReference.add(_loanContractReference.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanContractsReference.LoanContractsReferenceBuilder addLoanContractReference(LoanContractReference _loanContractReference, int idx) {
			getIndex(this.loanContractReference, idx, () -> _loanContractReference.toBuilder());
			return this;
		}
		
		@Override
		public LoanContractsReference.LoanContractsReferenceBuilder addLoanContractReference(List<? extends LoanContractReference> loanContractReferences) {
			if (loanContractReferences != null) {
				for (final LoanContractReference toAdd : loanContractReferences) {
					this.loanContractReference.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("loanContractReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("loanContractReference")
		@Override
		public LoanContractsReference.LoanContractsReferenceBuilder setLoanContractReference(List<? extends LoanContractReference> loanContractReferences) {
			if (loanContractReferences == null) {
				this.loanContractReference = new ArrayList<>();
			} else {
				this.loanContractReference = loanContractReferences.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public LoanContractsReference build() {
			return new LoanContractsReference.LoanContractsReferenceImpl(this);
		}
		
		@Override
		public LoanContractsReference.LoanContractsReferenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanContractsReference.LoanContractsReferenceBuilder prune() {
			loanContractReference = loanContractReference.stream().filter(b->b!=null).<LoanContractReference.LoanContractReferenceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getLoanContractReference()!=null && getLoanContractReference().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanContractsReference.LoanContractsReferenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LoanContractsReference.LoanContractsReferenceBuilder o = (LoanContractsReference.LoanContractsReferenceBuilder) other;
			
			merger.mergeRosetta(getLoanContractReference(), o.getLoanContractReference(), this::getOrCreateLoanContractReference);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanContractsReference _that = getType().cast(o);
		
			if (!ListEquals.listEquals(loanContractReference, _that.getLoanContractReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (loanContractReference != null ? loanContractReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanContractsReferenceBuilder {" +
				"loanContractReference=" + this.loanContractReference +
			'}';
		}
	}
}
