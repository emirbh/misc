package iso20022.auth030.hkma.dtcc;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
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
import iso20022.auth030.hkma.dtcc.meta.FinancialInstitutionSector1__1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Provides detailed information concerning financial counterparties.
 * @version ${project.version}
 */
@RosettaDataType(value="FinancialInstitutionSector1__1", builder=FinancialInstitutionSector1__1.FinancialInstitutionSector1__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="FinancialInstitutionSector1__1", model="iso20022", builder=FinancialInstitutionSector1__1.FinancialInstitutionSector1__1BuilderImpl.class, version="${project.version}")
public interface FinancialInstitutionSector1__1 extends RosettaModelObject {

	FinancialInstitutionSector1__1Meta metaData = new FinancialInstitutionSector1__1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies the nature of the counterparty business activities.
	 */
	FinancialPartyClassification2Choice__1 getSctr();

	/*********************** Build Methods  ***********************/
	FinancialInstitutionSector1__1 build();
	
	FinancialInstitutionSector1__1.FinancialInstitutionSector1__1Builder toBuilder();
	
	static FinancialInstitutionSector1__1.FinancialInstitutionSector1__1Builder builder() {
		return new FinancialInstitutionSector1__1.FinancialInstitutionSector1__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FinancialInstitutionSector1__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FinancialInstitutionSector1__1> getType() {
		return FinancialInstitutionSector1__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("sctr"), processor, FinancialPartyClassification2Choice__1.class, getSctr());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FinancialInstitutionSector1__1Builder extends FinancialInstitutionSector1__1, RosettaModelObjectBuilder {
		FinancialPartyClassification2Choice__1.FinancialPartyClassification2Choice__1Builder getOrCreateSctr();
		@Override
		FinancialPartyClassification2Choice__1.FinancialPartyClassification2Choice__1Builder getSctr();
		FinancialInstitutionSector1__1.FinancialInstitutionSector1__1Builder setSctr(FinancialPartyClassification2Choice__1 sctr);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("sctr"), processor, FinancialPartyClassification2Choice__1.FinancialPartyClassification2Choice__1Builder.class, getSctr());
		}
		

		FinancialInstitutionSector1__1.FinancialInstitutionSector1__1Builder prune();
	}

	/*********************** Immutable Implementation of FinancialInstitutionSector1__1  ***********************/
	class FinancialInstitutionSector1__1Impl implements FinancialInstitutionSector1__1 {
		private final FinancialPartyClassification2Choice__1 sctr;
		
		protected FinancialInstitutionSector1__1Impl(FinancialInstitutionSector1__1.FinancialInstitutionSector1__1Builder builder) {
			this.sctr = ofNullable(builder.getSctr()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("sctr")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("sctr")
		public FinancialPartyClassification2Choice__1 getSctr() {
			return sctr;
		}
		
		@Override
		public FinancialInstitutionSector1__1 build() {
			return this;
		}
		
		@Override
		public FinancialInstitutionSector1__1.FinancialInstitutionSector1__1Builder toBuilder() {
			FinancialInstitutionSector1__1.FinancialInstitutionSector1__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FinancialInstitutionSector1__1.FinancialInstitutionSector1__1Builder builder) {
			ofNullable(getSctr()).ifPresent(builder::setSctr);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FinancialInstitutionSector1__1 _that = getType().cast(o);
		
			if (!Objects.equals(sctr, _that.getSctr())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (sctr != null ? sctr.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FinancialInstitutionSector1__1 {" +
				"sctr=" + this.sctr +
			'}';
		}
	}

	/*********************** Builder Implementation of FinancialInstitutionSector1__1  ***********************/
	class FinancialInstitutionSector1__1BuilderImpl implements FinancialInstitutionSector1__1.FinancialInstitutionSector1__1Builder {
	
		protected FinancialPartyClassification2Choice__1.FinancialPartyClassification2Choice__1Builder sctr;
		
		@Override
		@RosettaAttribute("sctr")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("sctr")
		public FinancialPartyClassification2Choice__1.FinancialPartyClassification2Choice__1Builder getSctr() {
			return sctr;
		}
		
		@Override
		public FinancialPartyClassification2Choice__1.FinancialPartyClassification2Choice__1Builder getOrCreateSctr() {
			FinancialPartyClassification2Choice__1.FinancialPartyClassification2Choice__1Builder result;
			if (sctr!=null) {
				result = sctr;
			}
			else {
				result = sctr = FinancialPartyClassification2Choice__1.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("sctr")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("sctr")
		@Override
		public FinancialInstitutionSector1__1.FinancialInstitutionSector1__1Builder setSctr(FinancialPartyClassification2Choice__1 _sctr) {
			this.sctr = _sctr == null ? null : _sctr.toBuilder();
			return this;
		}
		
		@Override
		public FinancialInstitutionSector1__1 build() {
			return new FinancialInstitutionSector1__1.FinancialInstitutionSector1__1Impl(this);
		}
		
		@Override
		public FinancialInstitutionSector1__1.FinancialInstitutionSector1__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FinancialInstitutionSector1__1.FinancialInstitutionSector1__1Builder prune() {
			if (sctr!=null && !sctr.prune().hasData()) sctr = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getSctr()!=null && getSctr().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FinancialInstitutionSector1__1.FinancialInstitutionSector1__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FinancialInstitutionSector1__1.FinancialInstitutionSector1__1Builder o = (FinancialInstitutionSector1__1.FinancialInstitutionSector1__1Builder) other;
			
			merger.mergeRosetta(getSctr(), o.getSctr(), this::setSctr);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FinancialInstitutionSector1__1 _that = getType().cast(o);
		
			if (!Objects.equals(sctr, _that.getSctr())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (sctr != null ? sctr.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FinancialInstitutionSector1__1Builder {" +
				"sctr=" + this.sctr +
			'}';
		}
	}
}
