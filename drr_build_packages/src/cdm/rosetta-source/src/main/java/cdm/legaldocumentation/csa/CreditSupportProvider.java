package cdm.legaldocumentation.csa;

import cdm.legaldocumentation.csa.meta.CreditSupportProviderMeta;
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
 * Identification of party specific Credit Support Providers applicable to the document.
 * @version 6.23.0
 */
@RosettaDataType(value="CreditSupportProvider", builder=CreditSupportProvider.CreditSupportProviderBuilderImpl.class, version="6.23.0")
@RuneDataType(value="CreditSupportProvider", model="cdm", builder=CreditSupportProvider.CreditSupportProviderBuilderImpl.class, version="6.23.0")
public interface CreditSupportProvider extends RosettaModelObject {

	CreditSupportProviderMeta metaData = new CreditSupportProviderMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The party election of Credit Support Provider(s), if any.
	 */
	List<? extends CreditSupportProviderElection> getCreditSupportProviderElection();

	/*********************** Build Methods  ***********************/
	CreditSupportProvider build();
	
	CreditSupportProvider.CreditSupportProviderBuilder toBuilder();
	
	static CreditSupportProvider.CreditSupportProviderBuilder builder() {
		return new CreditSupportProvider.CreditSupportProviderBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CreditSupportProvider> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CreditSupportProvider> getType() {
		return CreditSupportProvider.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("creditSupportProviderElection"), processor, CreditSupportProviderElection.class, getCreditSupportProviderElection());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CreditSupportProviderBuilder extends CreditSupportProvider, RosettaModelObjectBuilder {
		CreditSupportProviderElection.CreditSupportProviderElectionBuilder getOrCreateCreditSupportProviderElection(int index);
		@Override
		List<? extends CreditSupportProviderElection.CreditSupportProviderElectionBuilder> getCreditSupportProviderElection();
		CreditSupportProvider.CreditSupportProviderBuilder addCreditSupportProviderElection(CreditSupportProviderElection creditSupportProviderElection);
		CreditSupportProvider.CreditSupportProviderBuilder addCreditSupportProviderElection(CreditSupportProviderElection creditSupportProviderElection, int idx);
		CreditSupportProvider.CreditSupportProviderBuilder addCreditSupportProviderElection(List<? extends CreditSupportProviderElection> creditSupportProviderElection);
		CreditSupportProvider.CreditSupportProviderBuilder setCreditSupportProviderElection(List<? extends CreditSupportProviderElection> creditSupportProviderElection);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("creditSupportProviderElection"), processor, CreditSupportProviderElection.CreditSupportProviderElectionBuilder.class, getCreditSupportProviderElection());
		}
		

		CreditSupportProvider.CreditSupportProviderBuilder prune();
	}

	/*********************** Immutable Implementation of CreditSupportProvider  ***********************/
	class CreditSupportProviderImpl implements CreditSupportProvider {
		private final List<? extends CreditSupportProviderElection> creditSupportProviderElection;
		
		protected CreditSupportProviderImpl(CreditSupportProvider.CreditSupportProviderBuilder builder) {
			this.creditSupportProviderElection = ofNullable(builder.getCreditSupportProviderElection()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("creditSupportProviderElection")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("creditSupportProviderElection")
		public List<? extends CreditSupportProviderElection> getCreditSupportProviderElection() {
			return creditSupportProviderElection;
		}
		
		@Override
		public CreditSupportProvider build() {
			return this;
		}
		
		@Override
		public CreditSupportProvider.CreditSupportProviderBuilder toBuilder() {
			CreditSupportProvider.CreditSupportProviderBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CreditSupportProvider.CreditSupportProviderBuilder builder) {
			ofNullable(getCreditSupportProviderElection()).ifPresent(builder::setCreditSupportProviderElection);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CreditSupportProvider _that = getType().cast(o);
		
			if (!ListEquals.listEquals(creditSupportProviderElection, _that.getCreditSupportProviderElection())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (creditSupportProviderElection != null ? creditSupportProviderElection.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditSupportProvider {" +
				"creditSupportProviderElection=" + this.creditSupportProviderElection +
			'}';
		}
	}

	/*********************** Builder Implementation of CreditSupportProvider  ***********************/
	class CreditSupportProviderBuilderImpl implements CreditSupportProvider.CreditSupportProviderBuilder {
	
		protected List<CreditSupportProviderElection.CreditSupportProviderElectionBuilder> creditSupportProviderElection = new ArrayList<>();
		
		@Override
		@RosettaAttribute("creditSupportProviderElection")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("creditSupportProviderElection")
		public List<? extends CreditSupportProviderElection.CreditSupportProviderElectionBuilder> getCreditSupportProviderElection() {
			return creditSupportProviderElection;
		}
		
		@Override
		public CreditSupportProviderElection.CreditSupportProviderElectionBuilder getOrCreateCreditSupportProviderElection(int index) {
			if (creditSupportProviderElection==null) {
				this.creditSupportProviderElection = new ArrayList<>();
			}
			return getIndex(creditSupportProviderElection, index, () -> {
						CreditSupportProviderElection.CreditSupportProviderElectionBuilder newCreditSupportProviderElection = CreditSupportProviderElection.builder();
						return newCreditSupportProviderElection;
					});
		}
		
		@RosettaAttribute("creditSupportProviderElection")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("creditSupportProviderElection")
		@Override
		public CreditSupportProvider.CreditSupportProviderBuilder addCreditSupportProviderElection(CreditSupportProviderElection _creditSupportProviderElection) {
			if (_creditSupportProviderElection != null) {
				this.creditSupportProviderElection.add(_creditSupportProviderElection.toBuilder());
			}
			return this;
		}
		
		@Override
		public CreditSupportProvider.CreditSupportProviderBuilder addCreditSupportProviderElection(CreditSupportProviderElection _creditSupportProviderElection, int idx) {
			getIndex(this.creditSupportProviderElection, idx, () -> _creditSupportProviderElection.toBuilder());
			return this;
		}
		
		@Override
		public CreditSupportProvider.CreditSupportProviderBuilder addCreditSupportProviderElection(List<? extends CreditSupportProviderElection> creditSupportProviderElections) {
			if (creditSupportProviderElections != null) {
				for (final CreditSupportProviderElection toAdd : creditSupportProviderElections) {
					this.creditSupportProviderElection.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("creditSupportProviderElection")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("creditSupportProviderElection")
		@Override
		public CreditSupportProvider.CreditSupportProviderBuilder setCreditSupportProviderElection(List<? extends CreditSupportProviderElection> creditSupportProviderElections) {
			if (creditSupportProviderElections == null) {
				this.creditSupportProviderElection = new ArrayList<>();
			} else {
				this.creditSupportProviderElection = creditSupportProviderElections.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public CreditSupportProvider build() {
			return new CreditSupportProvider.CreditSupportProviderImpl(this);
		}
		
		@Override
		public CreditSupportProvider.CreditSupportProviderBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditSupportProvider.CreditSupportProviderBuilder prune() {
			creditSupportProviderElection = creditSupportProviderElection.stream().filter(b->b!=null).<CreditSupportProviderElection.CreditSupportProviderElectionBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCreditSupportProviderElection()!=null && getCreditSupportProviderElection().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditSupportProvider.CreditSupportProviderBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CreditSupportProvider.CreditSupportProviderBuilder o = (CreditSupportProvider.CreditSupportProviderBuilder) other;
			
			merger.mergeRosetta(getCreditSupportProviderElection(), o.getCreditSupportProviderElection(), this::getOrCreateCreditSupportProviderElection);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CreditSupportProvider _that = getType().cast(o);
		
			if (!ListEquals.listEquals(creditSupportProviderElection, _that.getCreditSupportProviderElection())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (creditSupportProviderElection != null ? creditSupportProviderElection.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditSupportProviderBuilder {" +
				"creditSupportProviderElection=" + this.creditSupportProviderElection +
			'}';
		}
	}
}
