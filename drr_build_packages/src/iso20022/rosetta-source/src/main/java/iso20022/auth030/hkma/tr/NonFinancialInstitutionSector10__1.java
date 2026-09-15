package iso20022.auth030.hkma.tr;

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
import iso20022.auth030.hkma.tr.meta.NonFinancialInstitutionSector10__1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Provides detailed information concerning non financial counterparties.
 * @version ${project.version}
 */
@RosettaDataType(value="NonFinancialInstitutionSector10__1", builder=NonFinancialInstitutionSector10__1.NonFinancialInstitutionSector10__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="NonFinancialInstitutionSector10__1", model="iso20022", builder=NonFinancialInstitutionSector10__1.NonFinancialInstitutionSector10__1BuilderImpl.class, version="${project.version}")
public interface NonFinancialInstitutionSector10__1 extends RosettaModelObject {

	NonFinancialInstitutionSector10__1Meta metaData = new NonFinancialInstitutionSector10__1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Taxonomy for non-financial counterparties. The categories correspond to the main sections of NACE classification as defined in the regulation.
	 */
	GenericIdentification175__1 getSctr();

	/*********************** Build Methods  ***********************/
	NonFinancialInstitutionSector10__1 build();
	
	NonFinancialInstitutionSector10__1.NonFinancialInstitutionSector10__1Builder toBuilder();
	
	static NonFinancialInstitutionSector10__1.NonFinancialInstitutionSector10__1Builder builder() {
		return new NonFinancialInstitutionSector10__1.NonFinancialInstitutionSector10__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends NonFinancialInstitutionSector10__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends NonFinancialInstitutionSector10__1> getType() {
		return NonFinancialInstitutionSector10__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("sctr"), processor, GenericIdentification175__1.class, getSctr());
	}
	

	/*********************** Builder Interface  ***********************/
	interface NonFinancialInstitutionSector10__1Builder extends NonFinancialInstitutionSector10__1, RosettaModelObjectBuilder {
		GenericIdentification175__1.GenericIdentification175__1Builder getOrCreateSctr();
		@Override
		GenericIdentification175__1.GenericIdentification175__1Builder getSctr();
		NonFinancialInstitutionSector10__1.NonFinancialInstitutionSector10__1Builder setSctr(GenericIdentification175__1 sctr);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("sctr"), processor, GenericIdentification175__1.GenericIdentification175__1Builder.class, getSctr());
		}
		

		NonFinancialInstitutionSector10__1.NonFinancialInstitutionSector10__1Builder prune();
	}

	/*********************** Immutable Implementation of NonFinancialInstitutionSector10__1  ***********************/
	class NonFinancialInstitutionSector10__1Impl implements NonFinancialInstitutionSector10__1 {
		private final GenericIdentification175__1 sctr;
		
		protected NonFinancialInstitutionSector10__1Impl(NonFinancialInstitutionSector10__1.NonFinancialInstitutionSector10__1Builder builder) {
			this.sctr = ofNullable(builder.getSctr()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("sctr")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("sctr")
		public GenericIdentification175__1 getSctr() {
			return sctr;
		}
		
		@Override
		public NonFinancialInstitutionSector10__1 build() {
			return this;
		}
		
		@Override
		public NonFinancialInstitutionSector10__1.NonFinancialInstitutionSector10__1Builder toBuilder() {
			NonFinancialInstitutionSector10__1.NonFinancialInstitutionSector10__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(NonFinancialInstitutionSector10__1.NonFinancialInstitutionSector10__1Builder builder) {
			ofNullable(getSctr()).ifPresent(builder::setSctr);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NonFinancialInstitutionSector10__1 _that = getType().cast(o);
		
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
			return "NonFinancialInstitutionSector10__1 {" +
				"sctr=" + this.sctr +
			'}';
		}
	}

	/*********************** Builder Implementation of NonFinancialInstitutionSector10__1  ***********************/
	class NonFinancialInstitutionSector10__1BuilderImpl implements NonFinancialInstitutionSector10__1.NonFinancialInstitutionSector10__1Builder {
	
		protected GenericIdentification175__1.GenericIdentification175__1Builder sctr;
		
		@Override
		@RosettaAttribute("sctr")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("sctr")
		public GenericIdentification175__1.GenericIdentification175__1Builder getSctr() {
			return sctr;
		}
		
		@Override
		public GenericIdentification175__1.GenericIdentification175__1Builder getOrCreateSctr() {
			GenericIdentification175__1.GenericIdentification175__1Builder result;
			if (sctr!=null) {
				result = sctr;
			}
			else {
				result = sctr = GenericIdentification175__1.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("sctr")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("sctr")
		@Override
		public NonFinancialInstitutionSector10__1.NonFinancialInstitutionSector10__1Builder setSctr(GenericIdentification175__1 _sctr) {
			this.sctr = _sctr == null ? null : _sctr.toBuilder();
			return this;
		}
		
		@Override
		public NonFinancialInstitutionSector10__1 build() {
			return new NonFinancialInstitutionSector10__1.NonFinancialInstitutionSector10__1Impl(this);
		}
		
		@Override
		public NonFinancialInstitutionSector10__1.NonFinancialInstitutionSector10__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NonFinancialInstitutionSector10__1.NonFinancialInstitutionSector10__1Builder prune() {
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
		public NonFinancialInstitutionSector10__1.NonFinancialInstitutionSector10__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			NonFinancialInstitutionSector10__1.NonFinancialInstitutionSector10__1Builder o = (NonFinancialInstitutionSector10__1.NonFinancialInstitutionSector10__1Builder) other;
			
			merger.mergeRosetta(getSctr(), o.getSctr(), this::setSctr);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NonFinancialInstitutionSector10__1 _that = getType().cast(o);
		
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
			return "NonFinancialInstitutionSector10__1Builder {" +
				"sctr=" + this.sctr +
			'}';
		}
	}
}
