package iso20022.auth108.iso;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import iso20022.auth108.iso.meta.FinancialPartyClassification2ChoiceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Specifies the classification of a financial institution.
 * @version ${project.version}
 */
@RosettaDataType(value="FinancialPartyClassification2Choice", builder=FinancialPartyClassification2Choice.FinancialPartyClassification2ChoiceBuilderImpl.class, version="${project.version}")
@RuneDataType(value="FinancialPartyClassification2Choice", model="iso20022", builder=FinancialPartyClassification2Choice.FinancialPartyClassification2ChoiceBuilderImpl.class, version="${project.version}")
public interface FinancialPartyClassification2Choice extends RosettaModelObject {

	FinancialPartyClassification2ChoiceMeta metaData = new FinancialPartyClassification2ChoiceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Classification of the business activities of the counterparty via a pre-determined code list.
	 */
	FinancialPartySectorType3Code getCd();
	/**
	 * Classification of the business activities of the counterparty using a proprietary identification scheme.
	 */
	GenericIdentification175 getPrtry();

	/*********************** Build Methods  ***********************/
	FinancialPartyClassification2Choice build();
	
	FinancialPartyClassification2Choice.FinancialPartyClassification2ChoiceBuilder toBuilder();
	
	static FinancialPartyClassification2Choice.FinancialPartyClassification2ChoiceBuilder builder() {
		return new FinancialPartyClassification2Choice.FinancialPartyClassification2ChoiceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FinancialPartyClassification2Choice> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FinancialPartyClassification2Choice> getType() {
		return FinancialPartyClassification2Choice.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("cd"), FinancialPartySectorType3Code.class, getCd(), this);
		processRosetta(path.newSubPath("prtry"), processor, GenericIdentification175.class, getPrtry());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FinancialPartyClassification2ChoiceBuilder extends FinancialPartyClassification2Choice, RosettaModelObjectBuilder {
		GenericIdentification175.GenericIdentification175Builder getOrCreatePrtry();
		@Override
		GenericIdentification175.GenericIdentification175Builder getPrtry();
		FinancialPartyClassification2Choice.FinancialPartyClassification2ChoiceBuilder setCd(FinancialPartySectorType3Code cd);
		FinancialPartyClassification2Choice.FinancialPartyClassification2ChoiceBuilder setPrtry(GenericIdentification175 prtry);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("cd"), FinancialPartySectorType3Code.class, getCd(), this);
			processRosetta(path.newSubPath("prtry"), processor, GenericIdentification175.GenericIdentification175Builder.class, getPrtry());
		}
		

		FinancialPartyClassification2Choice.FinancialPartyClassification2ChoiceBuilder prune();
	}

	/*********************** Immutable Implementation of FinancialPartyClassification2Choice  ***********************/
	class FinancialPartyClassification2ChoiceImpl implements FinancialPartyClassification2Choice {
		private final FinancialPartySectorType3Code cd;
		private final GenericIdentification175 prtry;
		
		protected FinancialPartyClassification2ChoiceImpl(FinancialPartyClassification2Choice.FinancialPartyClassification2ChoiceBuilder builder) {
			this.cd = builder.getCd();
			this.prtry = ofNullable(builder.getPrtry()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("cd")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cd")
		public FinancialPartySectorType3Code getCd() {
			return cd;
		}
		
		@Override
		@RosettaAttribute("prtry")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("prtry")
		public GenericIdentification175 getPrtry() {
			return prtry;
		}
		
		@Override
		public FinancialPartyClassification2Choice build() {
			return this;
		}
		
		@Override
		public FinancialPartyClassification2Choice.FinancialPartyClassification2ChoiceBuilder toBuilder() {
			FinancialPartyClassification2Choice.FinancialPartyClassification2ChoiceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FinancialPartyClassification2Choice.FinancialPartyClassification2ChoiceBuilder builder) {
			ofNullable(getCd()).ifPresent(builder::setCd);
			ofNullable(getPrtry()).ifPresent(builder::setPrtry);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FinancialPartyClassification2Choice _that = getType().cast(o);
		
			if (!Objects.equals(cd, _that.getCd())) return false;
			if (!Objects.equals(prtry, _that.getPrtry())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (cd != null ? cd.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (prtry != null ? prtry.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FinancialPartyClassification2Choice {" +
				"cd=" + this.cd + ", " +
				"prtry=" + this.prtry +
			'}';
		}
	}

	/*********************** Builder Implementation of FinancialPartyClassification2Choice  ***********************/
	class FinancialPartyClassification2ChoiceBuilderImpl implements FinancialPartyClassification2Choice.FinancialPartyClassification2ChoiceBuilder {
	
		protected FinancialPartySectorType3Code cd;
		protected GenericIdentification175.GenericIdentification175Builder prtry;
		
		@Override
		@RosettaAttribute("cd")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cd")
		public FinancialPartySectorType3Code getCd() {
			return cd;
		}
		
		@Override
		@RosettaAttribute("prtry")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("prtry")
		public GenericIdentification175.GenericIdentification175Builder getPrtry() {
			return prtry;
		}
		
		@Override
		public GenericIdentification175.GenericIdentification175Builder getOrCreatePrtry() {
			GenericIdentification175.GenericIdentification175Builder result;
			if (prtry!=null) {
				result = prtry;
			}
			else {
				result = prtry = GenericIdentification175.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("cd")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cd")
		@Override
		public FinancialPartyClassification2Choice.FinancialPartyClassification2ChoiceBuilder setCd(FinancialPartySectorType3Code _cd) {
			this.cd = _cd == null ? null : _cd;
			return this;
		}
		
		@RosettaAttribute("prtry")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("prtry")
		@Override
		public FinancialPartyClassification2Choice.FinancialPartyClassification2ChoiceBuilder setPrtry(GenericIdentification175 _prtry) {
			this.prtry = _prtry == null ? null : _prtry.toBuilder();
			return this;
		}
		
		@Override
		public FinancialPartyClassification2Choice build() {
			return new FinancialPartyClassification2Choice.FinancialPartyClassification2ChoiceImpl(this);
		}
		
		@Override
		public FinancialPartyClassification2Choice.FinancialPartyClassification2ChoiceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FinancialPartyClassification2Choice.FinancialPartyClassification2ChoiceBuilder prune() {
			if (prtry!=null && !prtry.prune().hasData()) prtry = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCd()!=null) return true;
			if (getPrtry()!=null && getPrtry().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FinancialPartyClassification2Choice.FinancialPartyClassification2ChoiceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FinancialPartyClassification2Choice.FinancialPartyClassification2ChoiceBuilder o = (FinancialPartyClassification2Choice.FinancialPartyClassification2ChoiceBuilder) other;
			
			merger.mergeRosetta(getPrtry(), o.getPrtry(), this::setPrtry);
			
			merger.mergeBasic(getCd(), o.getCd(), this::setCd);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FinancialPartyClassification2Choice _that = getType().cast(o);
		
			if (!Objects.equals(cd, _that.getCd())) return false;
			if (!Objects.equals(prtry, _that.getPrtry())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (cd != null ? cd.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (prtry != null ? prtry.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FinancialPartyClassification2ChoiceBuilder {" +
				"cd=" + this.cd + ", " +
				"prtry=" + this.prtry +
			'}';
		}
	}
}
