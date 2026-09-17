package cdm.legaldocumentation.csa;

import cdm.legaldocumentation.csa.meta.CreditSupportDocumentMeta;
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
 * Identification of party specific Credit Support Documents applicable to the document.
 * @version 6.23.0
 */
@RosettaDataType(value="CreditSupportDocument", builder=CreditSupportDocument.CreditSupportDocumentBuilderImpl.class, version="6.23.0")
@RuneDataType(value="CreditSupportDocument", model="cdm", builder=CreditSupportDocument.CreditSupportDocumentBuilderImpl.class, version="6.23.0")
public interface CreditSupportDocument extends RosettaModelObject {

	CreditSupportDocumentMeta metaData = new CreditSupportDocumentMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The party election of Credit Support Document(s), if any.
	 */
	List<? extends CreditSupportDocumentElection> getCreditSupportDocumentElection();

	/*********************** Build Methods  ***********************/
	CreditSupportDocument build();
	
	CreditSupportDocument.CreditSupportDocumentBuilder toBuilder();
	
	static CreditSupportDocument.CreditSupportDocumentBuilder builder() {
		return new CreditSupportDocument.CreditSupportDocumentBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CreditSupportDocument> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CreditSupportDocument> getType() {
		return CreditSupportDocument.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("creditSupportDocumentElection"), processor, CreditSupportDocumentElection.class, getCreditSupportDocumentElection());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CreditSupportDocumentBuilder extends CreditSupportDocument, RosettaModelObjectBuilder {
		CreditSupportDocumentElection.CreditSupportDocumentElectionBuilder getOrCreateCreditSupportDocumentElection(int index);
		@Override
		List<? extends CreditSupportDocumentElection.CreditSupportDocumentElectionBuilder> getCreditSupportDocumentElection();
		CreditSupportDocument.CreditSupportDocumentBuilder addCreditSupportDocumentElection(CreditSupportDocumentElection creditSupportDocumentElection);
		CreditSupportDocument.CreditSupportDocumentBuilder addCreditSupportDocumentElection(CreditSupportDocumentElection creditSupportDocumentElection, int idx);
		CreditSupportDocument.CreditSupportDocumentBuilder addCreditSupportDocumentElection(List<? extends CreditSupportDocumentElection> creditSupportDocumentElection);
		CreditSupportDocument.CreditSupportDocumentBuilder setCreditSupportDocumentElection(List<? extends CreditSupportDocumentElection> creditSupportDocumentElection);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("creditSupportDocumentElection"), processor, CreditSupportDocumentElection.CreditSupportDocumentElectionBuilder.class, getCreditSupportDocumentElection());
		}
		

		CreditSupportDocument.CreditSupportDocumentBuilder prune();
	}

	/*********************** Immutable Implementation of CreditSupportDocument  ***********************/
	class CreditSupportDocumentImpl implements CreditSupportDocument {
		private final List<? extends CreditSupportDocumentElection> creditSupportDocumentElection;
		
		protected CreditSupportDocumentImpl(CreditSupportDocument.CreditSupportDocumentBuilder builder) {
			this.creditSupportDocumentElection = ofNullable(builder.getCreditSupportDocumentElection()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("creditSupportDocumentElection")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("creditSupportDocumentElection")
		public List<? extends CreditSupportDocumentElection> getCreditSupportDocumentElection() {
			return creditSupportDocumentElection;
		}
		
		@Override
		public CreditSupportDocument build() {
			return this;
		}
		
		@Override
		public CreditSupportDocument.CreditSupportDocumentBuilder toBuilder() {
			CreditSupportDocument.CreditSupportDocumentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CreditSupportDocument.CreditSupportDocumentBuilder builder) {
			ofNullable(getCreditSupportDocumentElection()).ifPresent(builder::setCreditSupportDocumentElection);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CreditSupportDocument _that = getType().cast(o);
		
			if (!ListEquals.listEquals(creditSupportDocumentElection, _that.getCreditSupportDocumentElection())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (creditSupportDocumentElection != null ? creditSupportDocumentElection.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditSupportDocument {" +
				"creditSupportDocumentElection=" + this.creditSupportDocumentElection +
			'}';
		}
	}

	/*********************** Builder Implementation of CreditSupportDocument  ***********************/
	class CreditSupportDocumentBuilderImpl implements CreditSupportDocument.CreditSupportDocumentBuilder {
	
		protected List<CreditSupportDocumentElection.CreditSupportDocumentElectionBuilder> creditSupportDocumentElection = new ArrayList<>();
		
		@Override
		@RosettaAttribute("creditSupportDocumentElection")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("creditSupportDocumentElection")
		public List<? extends CreditSupportDocumentElection.CreditSupportDocumentElectionBuilder> getCreditSupportDocumentElection() {
			return creditSupportDocumentElection;
		}
		
		@Override
		public CreditSupportDocumentElection.CreditSupportDocumentElectionBuilder getOrCreateCreditSupportDocumentElection(int index) {
			if (creditSupportDocumentElection==null) {
				this.creditSupportDocumentElection = new ArrayList<>();
			}
			return getIndex(creditSupportDocumentElection, index, () -> {
						CreditSupportDocumentElection.CreditSupportDocumentElectionBuilder newCreditSupportDocumentElection = CreditSupportDocumentElection.builder();
						return newCreditSupportDocumentElection;
					});
		}
		
		@RosettaAttribute("creditSupportDocumentElection")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("creditSupportDocumentElection")
		@Override
		public CreditSupportDocument.CreditSupportDocumentBuilder addCreditSupportDocumentElection(CreditSupportDocumentElection _creditSupportDocumentElection) {
			if (_creditSupportDocumentElection != null) {
				this.creditSupportDocumentElection.add(_creditSupportDocumentElection.toBuilder());
			}
			return this;
		}
		
		@Override
		public CreditSupportDocument.CreditSupportDocumentBuilder addCreditSupportDocumentElection(CreditSupportDocumentElection _creditSupportDocumentElection, int idx) {
			getIndex(this.creditSupportDocumentElection, idx, () -> _creditSupportDocumentElection.toBuilder());
			return this;
		}
		
		@Override
		public CreditSupportDocument.CreditSupportDocumentBuilder addCreditSupportDocumentElection(List<? extends CreditSupportDocumentElection> creditSupportDocumentElections) {
			if (creditSupportDocumentElections != null) {
				for (final CreditSupportDocumentElection toAdd : creditSupportDocumentElections) {
					this.creditSupportDocumentElection.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("creditSupportDocumentElection")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("creditSupportDocumentElection")
		@Override
		public CreditSupportDocument.CreditSupportDocumentBuilder setCreditSupportDocumentElection(List<? extends CreditSupportDocumentElection> creditSupportDocumentElections) {
			if (creditSupportDocumentElections == null) {
				this.creditSupportDocumentElection = new ArrayList<>();
			} else {
				this.creditSupportDocumentElection = creditSupportDocumentElections.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public CreditSupportDocument build() {
			return new CreditSupportDocument.CreditSupportDocumentImpl(this);
		}
		
		@Override
		public CreditSupportDocument.CreditSupportDocumentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditSupportDocument.CreditSupportDocumentBuilder prune() {
			creditSupportDocumentElection = creditSupportDocumentElection.stream().filter(b->b!=null).<CreditSupportDocumentElection.CreditSupportDocumentElectionBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCreditSupportDocumentElection()!=null && getCreditSupportDocumentElection().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditSupportDocument.CreditSupportDocumentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CreditSupportDocument.CreditSupportDocumentBuilder o = (CreditSupportDocument.CreditSupportDocumentBuilder) other;
			
			merger.mergeRosetta(getCreditSupportDocumentElection(), o.getCreditSupportDocumentElection(), this::getOrCreateCreditSupportDocumentElection);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CreditSupportDocument _that = getType().cast(o);
		
			if (!ListEquals.listEquals(creditSupportDocumentElection, _that.getCreditSupportDocumentElection())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (creditSupportDocumentElection != null ? creditSupportDocumentElection.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditSupportDocumentBuilder {" +
				"creditSupportDocumentElection=" + this.creditSupportDocumentElection +
			'}';
		}
	}
}
