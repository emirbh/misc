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
import iso20022.auth030.hkma.tr.meta.FinancialPartyClassification2Choice__1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Specifies the classification of a financial institution.
 * @version ${project.version}
 */
@RosettaDataType(value="FinancialPartyClassification2Choice__1", builder=FinancialPartyClassification2Choice__1.FinancialPartyClassification2Choice__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="FinancialPartyClassification2Choice__1", model="iso20022", builder=FinancialPartyClassification2Choice__1.FinancialPartyClassification2Choice__1BuilderImpl.class, version="${project.version}")
public interface FinancialPartyClassification2Choice__1 extends RosettaModelObject {

	FinancialPartyClassification2Choice__1Meta metaData = new FinancialPartyClassification2Choice__1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Classification of the business activities of the counterparty via a pre-determined code list.
	 */
	FinancialPartySectorType3Code getCd();

	/*********************** Build Methods  ***********************/
	FinancialPartyClassification2Choice__1 build();
	
	FinancialPartyClassification2Choice__1.FinancialPartyClassification2Choice__1Builder toBuilder();
	
	static FinancialPartyClassification2Choice__1.FinancialPartyClassification2Choice__1Builder builder() {
		return new FinancialPartyClassification2Choice__1.FinancialPartyClassification2Choice__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FinancialPartyClassification2Choice__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FinancialPartyClassification2Choice__1> getType() {
		return FinancialPartyClassification2Choice__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("cd"), FinancialPartySectorType3Code.class, getCd(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FinancialPartyClassification2Choice__1Builder extends FinancialPartyClassification2Choice__1, RosettaModelObjectBuilder {
		FinancialPartyClassification2Choice__1.FinancialPartyClassification2Choice__1Builder setCd(FinancialPartySectorType3Code cd);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("cd"), FinancialPartySectorType3Code.class, getCd(), this);
		}
		

		FinancialPartyClassification2Choice__1.FinancialPartyClassification2Choice__1Builder prune();
	}

	/*********************** Immutable Implementation of FinancialPartyClassification2Choice__1  ***********************/
	class FinancialPartyClassification2Choice__1Impl implements FinancialPartyClassification2Choice__1 {
		private final FinancialPartySectorType3Code cd;
		
		protected FinancialPartyClassification2Choice__1Impl(FinancialPartyClassification2Choice__1.FinancialPartyClassification2Choice__1Builder builder) {
			this.cd = builder.getCd();
		}
		
		@Override
		@RosettaAttribute("cd")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("cd")
		public FinancialPartySectorType3Code getCd() {
			return cd;
		}
		
		@Override
		public FinancialPartyClassification2Choice__1 build() {
			return this;
		}
		
		@Override
		public FinancialPartyClassification2Choice__1.FinancialPartyClassification2Choice__1Builder toBuilder() {
			FinancialPartyClassification2Choice__1.FinancialPartyClassification2Choice__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FinancialPartyClassification2Choice__1.FinancialPartyClassification2Choice__1Builder builder) {
			ofNullable(getCd()).ifPresent(builder::setCd);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FinancialPartyClassification2Choice__1 _that = getType().cast(o);
		
			if (!Objects.equals(cd, _that.getCd())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (cd != null ? cd.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FinancialPartyClassification2Choice__1 {" +
				"cd=" + this.cd +
			'}';
		}
	}

	/*********************** Builder Implementation of FinancialPartyClassification2Choice__1  ***********************/
	class FinancialPartyClassification2Choice__1BuilderImpl implements FinancialPartyClassification2Choice__1.FinancialPartyClassification2Choice__1Builder {
	
		protected FinancialPartySectorType3Code cd;
		
		@Override
		@RosettaAttribute("cd")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("cd")
		public FinancialPartySectorType3Code getCd() {
			return cd;
		}
		
		@RosettaAttribute("cd")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("cd")
		@Override
		public FinancialPartyClassification2Choice__1.FinancialPartyClassification2Choice__1Builder setCd(FinancialPartySectorType3Code _cd) {
			this.cd = _cd == null ? null : _cd;
			return this;
		}
		
		@Override
		public FinancialPartyClassification2Choice__1 build() {
			return new FinancialPartyClassification2Choice__1.FinancialPartyClassification2Choice__1Impl(this);
		}
		
		@Override
		public FinancialPartyClassification2Choice__1.FinancialPartyClassification2Choice__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FinancialPartyClassification2Choice__1.FinancialPartyClassification2Choice__1Builder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCd()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FinancialPartyClassification2Choice__1.FinancialPartyClassification2Choice__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FinancialPartyClassification2Choice__1.FinancialPartyClassification2Choice__1Builder o = (FinancialPartyClassification2Choice__1.FinancialPartyClassification2Choice__1Builder) other;
			
			
			merger.mergeBasic(getCd(), o.getCd(), this::setCd);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FinancialPartyClassification2Choice__1 _that = getType().cast(o);
		
			if (!Objects.equals(cd, _that.getCd())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (cd != null ? cd.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FinancialPartyClassification2Choice__1Builder {" +
				"cd=" + this.cd +
			'}';
		}
	}
}
