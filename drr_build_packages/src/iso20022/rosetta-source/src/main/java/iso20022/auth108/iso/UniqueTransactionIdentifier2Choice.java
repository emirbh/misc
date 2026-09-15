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
import iso20022.auth108.iso.meta.UniqueTransactionIdentifier2ChoiceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Element is a choice between a standard identifier and a proprietary code.
 * @version ${project.version}
 */
@RosettaDataType(value="UniqueTransactionIdentifier2Choice", builder=UniqueTransactionIdentifier2Choice.UniqueTransactionIdentifier2ChoiceBuilderImpl.class, version="${project.version}")
@RuneDataType(value="UniqueTransactionIdentifier2Choice", model="iso20022", builder=UniqueTransactionIdentifier2Choice.UniqueTransactionIdentifier2ChoiceBuilderImpl.class, version="${project.version}")
public interface UniqueTransactionIdentifier2Choice extends RosettaModelObject {

	UniqueTransactionIdentifier2ChoiceMeta metaData = new UniqueTransactionIdentifier2ChoiceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Unique trade identifier (UTI) as agreed with the counterparty.
	 */
	String getUnqTxIdr();
	/**
	 * Trade identifier expressed in a proprietary notation.
	 */
	GenericIdentification175 getPrtry();

	/*********************** Build Methods  ***********************/
	UniqueTransactionIdentifier2Choice build();
	
	UniqueTransactionIdentifier2Choice.UniqueTransactionIdentifier2ChoiceBuilder toBuilder();
	
	static UniqueTransactionIdentifier2Choice.UniqueTransactionIdentifier2ChoiceBuilder builder() {
		return new UniqueTransactionIdentifier2Choice.UniqueTransactionIdentifier2ChoiceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends UniqueTransactionIdentifier2Choice> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends UniqueTransactionIdentifier2Choice> getType() {
		return UniqueTransactionIdentifier2Choice.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("unqTxIdr"), String.class, getUnqTxIdr(), this);
		processRosetta(path.newSubPath("prtry"), processor, GenericIdentification175.class, getPrtry());
	}
	

	/*********************** Builder Interface  ***********************/
	interface UniqueTransactionIdentifier2ChoiceBuilder extends UniqueTransactionIdentifier2Choice, RosettaModelObjectBuilder {
		GenericIdentification175.GenericIdentification175Builder getOrCreatePrtry();
		@Override
		GenericIdentification175.GenericIdentification175Builder getPrtry();
		UniqueTransactionIdentifier2Choice.UniqueTransactionIdentifier2ChoiceBuilder setUnqTxIdr(String unqTxIdr);
		UniqueTransactionIdentifier2Choice.UniqueTransactionIdentifier2ChoiceBuilder setPrtry(GenericIdentification175 prtry);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("unqTxIdr"), String.class, getUnqTxIdr(), this);
			processRosetta(path.newSubPath("prtry"), processor, GenericIdentification175.GenericIdentification175Builder.class, getPrtry());
		}
		

		UniqueTransactionIdentifier2Choice.UniqueTransactionIdentifier2ChoiceBuilder prune();
	}

	/*********************** Immutable Implementation of UniqueTransactionIdentifier2Choice  ***********************/
	class UniqueTransactionIdentifier2ChoiceImpl implements UniqueTransactionIdentifier2Choice {
		private final String unqTxIdr;
		private final GenericIdentification175 prtry;
		
		protected UniqueTransactionIdentifier2ChoiceImpl(UniqueTransactionIdentifier2Choice.UniqueTransactionIdentifier2ChoiceBuilder builder) {
			this.unqTxIdr = builder.getUnqTxIdr();
			this.prtry = ofNullable(builder.getPrtry()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("unqTxIdr")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("unqTxIdr")
		public String getUnqTxIdr() {
			return unqTxIdr;
		}
		
		@Override
		@RosettaAttribute("prtry")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("prtry")
		public GenericIdentification175 getPrtry() {
			return prtry;
		}
		
		@Override
		public UniqueTransactionIdentifier2Choice build() {
			return this;
		}
		
		@Override
		public UniqueTransactionIdentifier2Choice.UniqueTransactionIdentifier2ChoiceBuilder toBuilder() {
			UniqueTransactionIdentifier2Choice.UniqueTransactionIdentifier2ChoiceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(UniqueTransactionIdentifier2Choice.UniqueTransactionIdentifier2ChoiceBuilder builder) {
			ofNullable(getUnqTxIdr()).ifPresent(builder::setUnqTxIdr);
			ofNullable(getPrtry()).ifPresent(builder::setPrtry);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			UniqueTransactionIdentifier2Choice _that = getType().cast(o);
		
			if (!Objects.equals(unqTxIdr, _that.getUnqTxIdr())) return false;
			if (!Objects.equals(prtry, _that.getPrtry())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (unqTxIdr != null ? unqTxIdr.hashCode() : 0);
			_result = 31 * _result + (prtry != null ? prtry.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "UniqueTransactionIdentifier2Choice {" +
				"unqTxIdr=" + this.unqTxIdr + ", " +
				"prtry=" + this.prtry +
			'}';
		}
	}

	/*********************** Builder Implementation of UniqueTransactionIdentifier2Choice  ***********************/
	class UniqueTransactionIdentifier2ChoiceBuilderImpl implements UniqueTransactionIdentifier2Choice.UniqueTransactionIdentifier2ChoiceBuilder {
	
		protected String unqTxIdr;
		protected GenericIdentification175.GenericIdentification175Builder prtry;
		
		@Override
		@RosettaAttribute("unqTxIdr")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("unqTxIdr")
		public String getUnqTxIdr() {
			return unqTxIdr;
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
		
		@RosettaAttribute("unqTxIdr")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("unqTxIdr")
		@Override
		public UniqueTransactionIdentifier2Choice.UniqueTransactionIdentifier2ChoiceBuilder setUnqTxIdr(String _unqTxIdr) {
			this.unqTxIdr = _unqTxIdr == null ? null : _unqTxIdr;
			return this;
		}
		
		@RosettaAttribute("prtry")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("prtry")
		@Override
		public UniqueTransactionIdentifier2Choice.UniqueTransactionIdentifier2ChoiceBuilder setPrtry(GenericIdentification175 _prtry) {
			this.prtry = _prtry == null ? null : _prtry.toBuilder();
			return this;
		}
		
		@Override
		public UniqueTransactionIdentifier2Choice build() {
			return new UniqueTransactionIdentifier2Choice.UniqueTransactionIdentifier2ChoiceImpl(this);
		}
		
		@Override
		public UniqueTransactionIdentifier2Choice.UniqueTransactionIdentifier2ChoiceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public UniqueTransactionIdentifier2Choice.UniqueTransactionIdentifier2ChoiceBuilder prune() {
			if (prtry!=null && !prtry.prune().hasData()) prtry = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getUnqTxIdr()!=null) return true;
			if (getPrtry()!=null && getPrtry().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public UniqueTransactionIdentifier2Choice.UniqueTransactionIdentifier2ChoiceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			UniqueTransactionIdentifier2Choice.UniqueTransactionIdentifier2ChoiceBuilder o = (UniqueTransactionIdentifier2Choice.UniqueTransactionIdentifier2ChoiceBuilder) other;
			
			merger.mergeRosetta(getPrtry(), o.getPrtry(), this::setPrtry);
			
			merger.mergeBasic(getUnqTxIdr(), o.getUnqTxIdr(), this::setUnqTxIdr);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			UniqueTransactionIdentifier2Choice _that = getType().cast(o);
		
			if (!Objects.equals(unqTxIdr, _that.getUnqTxIdr())) return false;
			if (!Objects.equals(prtry, _that.getPrtry())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (unqTxIdr != null ? unqTxIdr.hashCode() : 0);
			_result = 31 * _result + (prtry != null ? prtry.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "UniqueTransactionIdentifier2ChoiceBuilder {" +
				"unqTxIdr=" + this.unqTxIdr + ", " +
				"prtry=" + this.prtry +
			'}';
		}
	}
}
