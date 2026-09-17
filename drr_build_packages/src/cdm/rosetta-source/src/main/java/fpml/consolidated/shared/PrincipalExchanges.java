package fpml.consolidated.shared;

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
import fpml.consolidated.shared.meta.PrincipalExchangesMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type defining which principal exchanges occur for the stream.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type defining which principal exchanges occur for the stream.
 *
 */
@RosettaDataType(value="PrincipalExchanges", builder=PrincipalExchanges.PrincipalExchangesBuilderImpl.class, version="2.1.1")
@RuneDataType(value="PrincipalExchanges", model="fpml", builder=PrincipalExchanges.PrincipalExchangesBuilderImpl.class, version="2.1.1")
public interface PrincipalExchanges extends RosettaModelObject {

	PrincipalExchangesMeta metaData = new PrincipalExchangesMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	String getId();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A true/false flag to indicate whether there is an initial exchange of principal on the effective date.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A true/false flag to indicate whether there is an initial exchange of principal on the effective date.
	 *
	 */
	Boolean getInitialExchange();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A true/false flag to indicate whether there is a final exchange of principal on the termination date.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A true/false flag to indicate whether there is a final exchange of principal on the termination date.
	 *
	 */
	Boolean getFinalExchange();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A true/false flag to indicate whether there are intermediate or interim exchanges of principal during the term of the swap.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A true/false flag to indicate whether there are intermediate or interim exchanges of principal during the term of the swap.
	 *
	 */
	Boolean getIntermediateExchange();

	/*********************** Build Methods  ***********************/
	PrincipalExchanges build();
	
	PrincipalExchanges.PrincipalExchangesBuilder toBuilder();
	
	static PrincipalExchanges.PrincipalExchangesBuilder builder() {
		return new PrincipalExchanges.PrincipalExchangesBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PrincipalExchanges> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends PrincipalExchanges> getType() {
		return PrincipalExchanges.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("initialExchange"), Boolean.class, getInitialExchange(), this);
		processor.processBasic(path.newSubPath("finalExchange"), Boolean.class, getFinalExchange(), this);
		processor.processBasic(path.newSubPath("intermediateExchange"), Boolean.class, getIntermediateExchange(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface PrincipalExchangesBuilder extends PrincipalExchanges, RosettaModelObjectBuilder {
		PrincipalExchanges.PrincipalExchangesBuilder setId(String id);
		PrincipalExchanges.PrincipalExchangesBuilder setInitialExchange(Boolean initialExchange);
		PrincipalExchanges.PrincipalExchangesBuilder setFinalExchange(Boolean finalExchange);
		PrincipalExchanges.PrincipalExchangesBuilder setIntermediateExchange(Boolean intermediateExchange);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("initialExchange"), Boolean.class, getInitialExchange(), this);
			processor.processBasic(path.newSubPath("finalExchange"), Boolean.class, getFinalExchange(), this);
			processor.processBasic(path.newSubPath("intermediateExchange"), Boolean.class, getIntermediateExchange(), this);
		}
		

		PrincipalExchanges.PrincipalExchangesBuilder prune();
	}

	/*********************** Immutable Implementation of PrincipalExchanges  ***********************/
	class PrincipalExchangesImpl implements PrincipalExchanges {
		private final String id;
		private final Boolean initialExchange;
		private final Boolean finalExchange;
		private final Boolean intermediateExchange;
		
		protected PrincipalExchangesImpl(PrincipalExchanges.PrincipalExchangesBuilder builder) {
			this.id = builder.getId();
			this.initialExchange = builder.getInitialExchange();
			this.finalExchange = builder.getFinalExchange();
			this.intermediateExchange = builder.getIntermediateExchange();
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("initialExchange")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("initialExchange")
		public Boolean getInitialExchange() {
			return initialExchange;
		}
		
		@Override
		@RosettaAttribute("finalExchange")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("finalExchange")
		public Boolean getFinalExchange() {
			return finalExchange;
		}
		
		@Override
		@RosettaAttribute("intermediateExchange")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("intermediateExchange")
		public Boolean getIntermediateExchange() {
			return intermediateExchange;
		}
		
		@Override
		public PrincipalExchanges build() {
			return this;
		}
		
		@Override
		public PrincipalExchanges.PrincipalExchangesBuilder toBuilder() {
			PrincipalExchanges.PrincipalExchangesBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PrincipalExchanges.PrincipalExchangesBuilder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getInitialExchange()).ifPresent(builder::setInitialExchange);
			ofNullable(getFinalExchange()).ifPresent(builder::setFinalExchange);
			ofNullable(getIntermediateExchange()).ifPresent(builder::setIntermediateExchange);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PrincipalExchanges _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(initialExchange, _that.getInitialExchange())) return false;
			if (!Objects.equals(finalExchange, _that.getFinalExchange())) return false;
			if (!Objects.equals(intermediateExchange, _that.getIntermediateExchange())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (initialExchange != null ? initialExchange.hashCode() : 0);
			_result = 31 * _result + (finalExchange != null ? finalExchange.hashCode() : 0);
			_result = 31 * _result + (intermediateExchange != null ? intermediateExchange.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PrincipalExchanges {" +
				"id=" + this.id + ", " +
				"initialExchange=" + this.initialExchange + ", " +
				"finalExchange=" + this.finalExchange + ", " +
				"intermediateExchange=" + this.intermediateExchange +
			'}';
		}
	}

	/*********************** Builder Implementation of PrincipalExchanges  ***********************/
	class PrincipalExchangesBuilderImpl implements PrincipalExchanges.PrincipalExchangesBuilder {
	
		protected String id;
		protected Boolean initialExchange;
		protected Boolean finalExchange;
		protected Boolean intermediateExchange;
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("initialExchange")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("initialExchange")
		public Boolean getInitialExchange() {
			return initialExchange;
		}
		
		@Override
		@RosettaAttribute("finalExchange")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("finalExchange")
		public Boolean getFinalExchange() {
			return finalExchange;
		}
		
		@Override
		@RosettaAttribute("intermediateExchange")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("intermediateExchange")
		public Boolean getIntermediateExchange() {
			return intermediateExchange;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public PrincipalExchanges.PrincipalExchangesBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("initialExchange")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("initialExchange")
		@Override
		public PrincipalExchanges.PrincipalExchangesBuilder setInitialExchange(Boolean _initialExchange) {
			this.initialExchange = _initialExchange == null ? null : _initialExchange;
			return this;
		}
		
		@RosettaAttribute("finalExchange")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("finalExchange")
		@Override
		public PrincipalExchanges.PrincipalExchangesBuilder setFinalExchange(Boolean _finalExchange) {
			this.finalExchange = _finalExchange == null ? null : _finalExchange;
			return this;
		}
		
		@RosettaAttribute("intermediateExchange")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("intermediateExchange")
		@Override
		public PrincipalExchanges.PrincipalExchangesBuilder setIntermediateExchange(Boolean _intermediateExchange) {
			this.intermediateExchange = _intermediateExchange == null ? null : _intermediateExchange;
			return this;
		}
		
		@Override
		public PrincipalExchanges build() {
			return new PrincipalExchanges.PrincipalExchangesImpl(this);
		}
		
		@Override
		public PrincipalExchanges.PrincipalExchangesBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PrincipalExchanges.PrincipalExchangesBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			if (getInitialExchange()!=null) return true;
			if (getFinalExchange()!=null) return true;
			if (getIntermediateExchange()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PrincipalExchanges.PrincipalExchangesBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PrincipalExchanges.PrincipalExchangesBuilder o = (PrincipalExchanges.PrincipalExchangesBuilder) other;
			
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			merger.mergeBasic(getInitialExchange(), o.getInitialExchange(), this::setInitialExchange);
			merger.mergeBasic(getFinalExchange(), o.getFinalExchange(), this::setFinalExchange);
			merger.mergeBasic(getIntermediateExchange(), o.getIntermediateExchange(), this::setIntermediateExchange);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PrincipalExchanges _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(initialExchange, _that.getInitialExchange())) return false;
			if (!Objects.equals(finalExchange, _that.getFinalExchange())) return false;
			if (!Objects.equals(intermediateExchange, _that.getIntermediateExchange())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (initialExchange != null ? initialExchange.hashCode() : 0);
			_result = 31 * _result + (finalExchange != null ? finalExchange.hashCode() : 0);
			_result = 31 * _result + (intermediateExchange != null ? intermediateExchange.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PrincipalExchangesBuilder {" +
				"id=" + this.id + ", " +
				"initialExchange=" + this.initialExchange + ", " +
				"finalExchange=" + this.finalExchange + ", " +
				"intermediateExchange=" + this.intermediateExchange +
			'}';
		}
	}
}
